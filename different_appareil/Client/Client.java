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
    PrintWriter pw;
    String mess;
    Socket socket;

    public String get_ip() {return this.ip;}
    public int get_port() {return this.port;}
    public String get_path() {return this.path;}
    public PrintWriter get_pw() {return this.pw;}
    public String get_mess() {return this.mess;}
    public Socket get_socket() {return this.socket;}

    public void set_ip(String ip) {this.ip=ip;}
    public void set_port(int port) {this.port=port;}
    public void set_path(String path) {this.path=path;}
    public void set_pw(PrintWriter pw) {this.pw=pw;}
    public void set_mess(String mess) {this.mess=mess;}
    public void set_socket(Socket socket) {
        this.socket = socket;
    }

    private static DataOutputStream dataOutputStream = null;
    private static DataInputStream dataInputStream = null;

    public Client(String mess){
        set_mess(mess);
    }


    public Client(String ip, int port, String path, String mess) {
            set_mess(mess);
            set_pw(pw);
            set_ip(ip);
            set_port(port);
            set_path(path);

        try {
            Socket socket = new Socket(ip, port);
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            pw = new PrintWriter(socket.getOutputStream());
            send();
            Thread.sleep(100);
            System.out.println("Envoie du fichier au Serveur");
            sendFile(path);

            dataInputStream.close();
            dataOutputStream.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void send() throws Exception {
        set_mess(mess);
        pw.println(get_mess());
        pw.flush();
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