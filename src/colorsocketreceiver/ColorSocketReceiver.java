/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colorsocketreceiver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author J378925
 */
public class ColorSocketReceiver {

    private static final String ENDPOINT_ADDR = "localhost";
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                        int port = 0;
                        Socket skt = null;
                        BufferedReader in = null;
                        boolean recievedData = false;
                        
                        while(!recievedData){
                         Scanner reader = new Scanner(System.in);  // Reading from System.in
                        System.out.println("Enter the Port Number: ");
                        port = reader.nextInt(); // Scans the next token of the input as an int.
                        //once finished
                        reader.close();
                        try {
			skt = new Socket(ENDPOINT_ADDR, port);
			in = new BufferedReader(new InputStreamReader(skt.getInputStream()));
			System.out.print("Colors: ");			
			while (!in.ready()) { }
			System.out.print(in.readLine());
			in.close();
			skt.close();
			recievedData = true;
                        } catch (Exception e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                        }finally{
                                    try{
                                     if (skt != null && in != null) {
                                        skt.close();
                                        in.close();
                                    }   
                                    }catch(IOException e){
                                        System.out.println("Failed to connect to a server, please check port number and try again...");
                                        System.out.println(e.getMessage());
                                    }
                        }   
                        }
                        
    }
    
}
