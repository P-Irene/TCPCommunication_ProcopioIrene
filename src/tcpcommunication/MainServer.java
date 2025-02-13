/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tcpcommunication;

/**
 *
 * @author Irene
 */
public class MainServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Server s = new Server(1906);
        int count = 0;
        while(count < 5){
            System.out.println("Client n. " + (count+1));
            s.attendi();
            count ++;
            s.leggi();
            s.scrivi();
            s.chiudi();
        }
        s.termina();
    }
    
}
