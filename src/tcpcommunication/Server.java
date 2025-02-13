/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tcpcommunication;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket; //fanno parte della libreria java.net
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Irene
 */
public class Server {
    ServerSocket serverSocket;  //connection socket
    Socket clientSocket;  //data socket
    int porta;
    String ROSSO = "\u001B[31m";
    public static final String BLU = "\u001B[34m";
    InputStream is;
    OutputStream os;
    Scanner streamIn = null;
    PrintWriter streamOut = null;
    String messaggioIn, messaggioOut;
    
    public Server(int porta){
        this.porta = porta;
        try {         
            serverSocket = new ServerSocket(porta);
            System.out.println(ROSSO + "1)Server in ascolto\n");
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Errore del server nella fase di binding");
        }
    }
    
    public Socket attendi(){
        try {
            clientSocket = serverSocket.accept();
            System.out.println(BLU + "2)Connessione avvenuta e data socket creata.");
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Errori di connessione con il client");
        }
        return clientSocket;
    }
    
    public void leggi(){
        if(clientSocket != null)
            try {
                is = clientSocket.getInputStream();
                streamIn = new Scanner(is);

                messaggioIn = streamIn.next();
                System.out.println("3)Messaggio del client: " + messaggioIn);
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println("Errore di I/O!");
            }
    }
    
    public void scrivi(){
        if(clientSocket != null)
            try {
                os = clientSocket.getOutputStream();
                streamOut = new PrintWriter(os);

                messaggioOut = "Ciao client! Ti aspettavo!";
                streamOut.println(messaggioOut);
                streamOut.flush();
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println("Errore di I/O!");
            }
    }
    
    public void chiudi(){
        if(clientSocket != null)
            try {
                clientSocket.close();
                System.out.println(BLU + "5)Chiusura connessione con il client");
                System.out.println("---------------------------------------");
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println(BLU + "Errore di chiusura connession e con il client");
            }
    }
    
    public void termina(){
        if(serverSocket != null)
            try {
                serverSocket.close();
                System.out.println(ROSSO + "6)Chiusura della connessione del server");
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println("Errore nella chiusura della connessione");
            }
    }
}
