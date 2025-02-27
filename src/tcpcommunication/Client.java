/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tcpcommunication;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
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
    InputStream is;
    OutputStream os;
    String messaggioIn, messaggioOut;
    Scanner streamIn = null;
    PrintWriter streamOut = null;
    
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
            System.out.println(MainClient.BLU + "2)Connessione avvenuta con il server" + MainClient.RESET);
        } catch (ConnectException ex){
            System.err.println("Errore server non in ascolto");
        } catch (UnknownHostException ex){
            System.err.println("Errore risoluzione del nome del server");
        }catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Errore nella fase di connessione con il server");
        }
    }
    
    public String scrivi(){
        if(socket != null)
            try {
                System.out.println("Scrittura messaggio Client");
                os = socket.getOutputStream();
                streamOut = new PrintWriter(os);
                streamOut.flush();
                
                Scanner wr = new Scanner (System.in);
                System.out.print("Scrivi un messaggio: ");
                
                messaggioOut = wr.nextLine();
                streamOut.println(messaggioOut);
                streamOut.flush();
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println("Errore di I/O!");
            }
        return messaggioOut;
    }
    
    public void leggi(){
        try {
            is = socket.getInputStream();
            streamIn = new Scanner(is);
            
            messaggioIn = streamIn.nextLine();
            System.out.println("4)Messaggio del server: " + messaggioIn);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Errore di I/O!");
        }
    }
    
    public void chiudi(){
        if(socket != null)  //NullPointerException (NON CONTROLLATA)
            try {
                socket.close();
                System.out.println(MainClient.BLU + "5)Chiusura della connessione con il server" + MainClient.RESET);
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println("Errore di chiusura della connessione con il server");
            }
    } 
}
