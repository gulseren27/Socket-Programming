/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import java.net.*;
import java.io.*;
/**
 *
 * @author 200303044
 */
public class Client {
    
    public static void main(String[] args)  {
        
        Socket socket =null;
        String gönderilecek;
        
        try{
            socket = new Socket("172.19.169.50",5555);// (ip,port)- başka kullanıcıya bağlandı
            
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
        
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); //socketten gelen veriyi aldı
            
            BufferedReader data = new BufferedReader(new InputStreamReader(System.in)); // klavyeden aldı
            
            
            while((gönderilecek=data.readLine())!= null){
            
            out.println(gönderilecek);
            System.out.println("serverdan gelen:"+in.readLine());
            
            // diğer kullanıcıya bağlandıktan sonra terminale yazılan mesaj iletilir
        }
         
        
            
        }
        catch(Exception e){
        System.out.println("client hatası");
    }
    
}
}
// bu kodda sadece bir kişiye bağlanıp cevap verebilir fazlası için thread kullanılmalı (multiThreading)