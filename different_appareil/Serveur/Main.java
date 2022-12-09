package affichage;

import socket.*;

public class Main
{
    public static void main(String[] args)
    {
        Serveur s = new Serveur();
        s.start();
    }
}