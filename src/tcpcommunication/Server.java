/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tcpcommunication;

import java.io.IOException;
import java.net.ServerSocket; //fanno parte della libreria java.net
import java.net.Socket;
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
    
    public Server(int porta){
        this.porta = porta;
        try {
            serverSocket = new ServerSocket(porta);
            System.out.println("1)Server in ascolto.");
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Errore del server nella fase di binding");
        }
    }
    
    public Socket attendi(){
        try {
            clientSocket = serverSocket.accept();
            System.out.println("2)Connessione avvenuta e data socket creata");
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Errori di connessione con il client");
        }
        return clientSocket;
    }
    
    public void leggi(){
        
    }
    
    public void scrivi(){
        
    }
    
    public void chiudi(){
        if(clientSocket != null)
            try {
                clientSocket.close();
                System.out.println("5)Chiusura connessione con il client");
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public void termina(){
        if(serverSocket != null)
            try {
                serverSocket.close();
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
