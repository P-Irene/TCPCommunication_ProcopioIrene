/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tcpcommunication;

/**
 *
 * @author Irene
 */
public class MainClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Client c = new Client("irene", "\u001B[34m");
        c.connetti("localhost", 1906);
        c.scrivi();
        c.leggi();
        c.chiudi();
    }
    
}
