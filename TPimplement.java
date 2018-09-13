package com.sachet.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TPimplement implements Runnable{
    private Socket socket;
    public TPimplement(Socket socket){
        this.socket = socket;
    }
    public void run(){
        try{
            BufferedReader input = new BufferedReader(
                   new InputStreamReader(
                           socket.getInputStream())
            );
            PrintWriter output = new PrintWriter(
                    socket.getOutputStream()
                    ,true
            );
            String echoString;
            while(true){
                echoString = input.readLine();
                if(echoString.equals("exit")){
                    break;
                }
                System.out.println(socket.getPort()+":"
                        +echoString);
                output.println(echoString);
            }
        }catch(IOException e){
            try{
                socket.close();
            }catch(IOException e1){}
        }
    }
}
