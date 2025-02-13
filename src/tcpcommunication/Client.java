/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tcpcommunication;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Irene
 */
public class Client {
    String nome;
    String colore;
    Socket socket;
    
    public Client(String nome){
        this.nome = nome;
    }
    
    public Client (String nome, String colore){
        this.nome = nome;
        this.colore = colore;
    }
    
    public void connetti(String nomeServer, int portaServer){
        try {
            socket = new Socket(nomeServer, portaServer);
            System.out.println("1)Connessione avvenuta con il server");
        } catch (ConnectException ex){
            System.err.println("Errore server non in ascolto.");
        } catch (UnknownHostException ex){
            System.err.println("Errore risoluzione del nome del server.");
        }catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Errore nella fase di connessione con il server");
        }
    }
    
    public void scrivi(){
        
    }
    
    public void leggi(){
        
    }
    
    public void chiudi(){
        if(socket != null)  //NullPointerException (NON CONTROLLATA)
            try {
                socket.close();
                System.out.println("4)Chiusura della connessione con il server");
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
