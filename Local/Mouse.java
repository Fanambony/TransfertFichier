package ecouteur;

import socket.*;
import fenetre.*;

import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.*;
import java.awt.event.*;
import java.io.*;
import java.lang.reflect.*;
import java.net.ServerSocket;

public class Mouse implements MouseListener
{
    JButton but;
    Fenetre f;
    String ip;
    int port;
    String path;
    String fichier;

    public String get_ip() {return this.ip;}
    public int get_port() {return this.port;}
    public String get_path() {return this.path;}
    public String get_fichier() {return this.fichier;}

    public void set_ip(String ip) {this.ip=ip;}
    public void set_port(int port) {this.port=port;}
    public void set_path(String path) {this.path=path;}
    public void set_fichier(String fichier) {this.fichier=fichier;}

    public Mouse(JButton but, Fenetre f)
    {
        this.but = but;
        this.f = f;
    }

    public Mouse(String ip, int port, String path, String fichier) {
        set_ip(ip);
        set_port(port);
        set_path(path);
        set_fichier(fichier);
    }

    public void mouseClicked(MouseEvent e)
    {
        try  
        {
            if(this.but.getText()=="Upload")
            {
                this.set_ip(f.get_JTF().getText());
                this.set_port(Integer.valueOf(f.get_JTF1().getText()));

                System.out.println("upload");
                JFileChooser ch = new JFileChooser( FileSystemView.getFileSystemView().getHomeDirectory() );
                int res = ch.showOpenDialog(ch);
                if(res == JFileChooser.APPROVE_OPTION) {
                    File file = ch.getSelectedFile();

                    this.set_path(file.getAbsolutePath());
                    this.set_fichier(file.getName());

                    Serveur serveur = new Serveur(get_fichier());
                    serveur.start();

                    Client client = new Client(get_ip(), get_port(), get_path());
                }
            }
        }
        catch (Exception exe) {
            exe.printStackTrace();
        }
    }
    public void mouseEntered(MouseEvent e) {}
    public void	mouseExited(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
}