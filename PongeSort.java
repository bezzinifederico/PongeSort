/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pongesort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bezzini.federiconico
 */
public class PongeSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
           System.out.println("Apertua connessione");
         
        try {
             Socket server = new Socket("127.0.0.1",666);
             char [] arr = {'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'q', 'l'};
            PrintWriter out
                    = new PrintWriter(server.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(server.getInputStream()));
            Scanner tastiera = new Scanner(System.in);
            String s = "";
            
            while (!s.equals("exit")) {
                System.out.println("Inserire 10 caratteri:");
                s = tastiera.nextLine();
                String risposta = in.readLine();
                System.out.println("risposta del server: " + risposta);
                System.out.println("Hai inserito " + risposta.split(": ")[1]); 
                
            }

            in.close();
            server.close();
            System.out.println("chiusura della connessione effettuata");
        } catch (IOException ex) {
            Logger.getLogger(PongeSort.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
}
   