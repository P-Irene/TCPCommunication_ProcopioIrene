/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tcpcommunication;

import java.util.Scanner;
/**
 *
 * @author Irene
 */
public class MainClient {
    public static final String GIALLO_CHIARO = "\u001B[33m";
    public static final String VERDE = "\u001B[32m";
    public static final String VIOLA = "\u001B[35m";
    public static final String CIANO = "\u001B[36m";
    public static final String GIALLO = "\u001B[35m";
    public static final String RESET = "\u001B[0m";
    public static final String BLU = "\u001b[34m";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Client c1 = new Client("irene", GIALLO_CHIARO);
        c1.connetti("localhost", 1906);
        while(!(c1.scrivi().equals("termina"))){
            c1.scrivi();
            c1.leggi();
        }
        c1.chiudi();
    }
    
}
