package socket;

import fenetre.*;
import ecouteur.*;

import java.io.*;
import java.net.Socket;

import org.w3c.dom.events.MouseEvent;
 
public class Client {
    String ip = "";
    int port;
    String path;

    public String get_ip() {return this.ip;}
    public int get_port() {return this.port;}
    public String get_path() {return this.path;}

    public void set_ip(String ip) {this.ip=ip;}
    public void set_port(int port) {this.port=port;}
    public void set_path(String path) {this.path=path;}

    private static DataOutputStream dataOutputStream = null;
    private static DataInputStream dataInputStream = null;


    public Client(String ip, int port, String path) {
            set_ip(ip);
            set_port(port);
            set_path(path);

        try (
            Socket socket = new Socket(ip, port)) {
            dataInputStream = new DataInputStream( socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            System.out.println("Envoie du fichier au Serveur");
            sendFile(path);
            dataInputStream.close();
            dataInputStream.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
 
    public void sendFile(String path) throws Exception
    {
        int bytes = 0;
        File file = new File(path);
        FileInputStream fileInputStream = new FileInputStream(file);
        dataOutputStream.writeLong(file.length());
        byte[] buffer = new byte[4 * 1024];
        while ((bytes = fileInputStream.read(buffer)) != -1) {
            dataOutputStream.write(buffer, 0, bytes);
            dataOutputStream.flush();
        }
        fileInputStream.close();
    }
}