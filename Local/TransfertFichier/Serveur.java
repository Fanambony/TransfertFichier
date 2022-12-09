package socket;

import fenetre.*;
import ecouteur.*;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
 
public class Serveur extends Thread{
    String fichier;

    public String get_fichier() {return this.fichier;}

    public void set_fichier(String fichier) {this.fichier=fichier;}

    private static DataOutputStream dataOutputStream = null;
    private static DataInputStream dataInputStream = null;

    public Serveur(String fichier) {
        set_fichier(fichier);
    }

    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(1111)) {
            System.out.println("Serveur est pres pour le Port 900");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Connecter");
            dataInputStream = new DataInputStream(clientSocket.getInputStream());
            dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
            receiveFile("/E:/Documents/MrNaina/TransfertFichier/Local/fileRecus/"+get_fichier());
            
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
        FileOutputStream fileOutputStream
            = new FileOutputStream(fileName);
 
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