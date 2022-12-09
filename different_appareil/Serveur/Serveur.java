package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
 
public class Serveur extends Thread{
    BufferedReader in;

    public BufferedReader get_in() {return this.in;}

    public void set_in(BufferedReader in) {this.in=in;}

    private static DataOutputStream dataOutputStream = null;
    private static DataInputStream dataInputStream = null;

    public Serveur() {
        set_in(in);
    }

    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(1111)) {
            System.out.println("Serveur est pres pour le Port");
            Socket clientSocket = serverSocket.accept();

            set_in(new BufferedReader(new InputStreamReader(clientSocket.getInputStream())));

            System.out.println("Connecter");
            dataInputStream = new DataInputStream(clientSocket.getInputStream());
            dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
            
            String name = in.readLine();


            Thread.sleep(200);
            receiveFile("/E:/Documents/MrNaina/TransfertFichier/different_appareil/Serveur/recus/"+name);            
            
            dataInputStream.close();
            dataOutputStream.close();
            clientSocket.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void receiveFile(String fileName) throws Exception
    {
        int bytes = 0;
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
 
        long size = dataInputStream.readLong();
        byte[] buffer = new byte[4 * 1024];
        while (size > 0 && (bytes = dataInputStream.read(buffer, 0, (int)Math.min(buffer.length, size))) != -1) {
            fileOutputStream.write(buffer, 0, bytes);
            size -= bytes;
        }
        System.out.println("Fichier recus");
        fileOutputStream.close();
    }
}