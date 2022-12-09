package fenetre;

import socket.*;
import ecouteur.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Fenetre extends JFrame {
    JPanel container;
    JLabel label;
    JLabel label1;
    JTextField jtf;
    JTextField jtf1;
    JButton but;

    public JPanel get_container() {return this.container;}
    public JLabel get_label() {return this.label;}
    public JLabel get_label1() {return this.label1;}
    public JTextField get_JTF() {return this.jtf;}
    public JTextField get_JTF1() {return this.jtf1;}
    public JButton get_but() {return this.but;}

    public void set_container(JPanel container) {this.container=container;}
    public void set_label(JLabel label) {this.label=label;}
    public void set_label1(JLabel label1) {this.label1=label1;}
    public void set_JTF(JTextField jtf) {this.jtf=jtf;}
    public void set_JTF1(JTextField jtf1) {this.jtf1=jtf1;}
    public void set_but(JButton but) {this.but=but;}


    public Fenetre(){

        container = new JPanel();

        jtf = new JTextField();
        jtf1 = new JTextField();

        label = new JLabel("Adresse IP");
        label1 = new JLabel("PORT");
        
        but = new JButton("Upload");

        this.setTitle("Animation");
        this.setSize(750, 250);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
 
        get_container().setLayout(new BorderLayout());

        JPanel top = new JPanel();

        jtf.setPreferredSize(new Dimension(150, 30));

        jtf1.setPreferredSize(new Dimension(150, 30));

        top.add(label);
        top.add(jtf);

        top.add(label1);
        top.add(jtf1);

        top.add(but);

        container.add(top, BorderLayout.NORTH);

        but.addMouseListener(new Mouse(but, this));

        this.setContentPane(container);
        this.setVisible(true);
    }
}
