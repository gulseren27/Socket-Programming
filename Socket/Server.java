/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
/**
 *
 * @author 200303044
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        String clientMesaj;
        ServerSocket serverSocket=null;
        Socket clientSocket=null;
        
        
        try{
        serverSocket = new ServerSocket(5555);
        System.out.println("server başlatıldı");
        clientSocket = serverSocket.accept();
        System.out.println("bağlantı sağlandı");
        
        // mesaj göndermek için
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
        //mesaj almak için
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        
        while((clientMesaj=in.readLine())!= null){
            
            System.out.println("gelen mesaj = "+clientMesaj);
            out.println("merhaba mesajınız alındı"); // mesaj scannerla klavyeden alınabilir 
            
        }
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
        
        
        }catch(Exception e){
        System.out.println("port numarası hatalı veya dolu!");
    }
        
        
        
      
        
}
}