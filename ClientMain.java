package com.sachet.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientMain {

    public static void main(String[] args) {
	    try(Socket socket = new Socket("localhost"
        ,5000)){
	        BufferedReader input =
                    new BufferedReader(new InputStreamReader(
                            socket.getInputStream()));
            PrintWriter output = new PrintWriter(
               socket.getOutputStream(),true
            ) ;
            String responce;
            String stringtoEcho;
            Scanner scan = new Scanner(System.in);
            while(true){
                stringtoEcho = scan.nextLine();
                output.println(stringtoEcho);
                if(!stringtoEcho.equals("exit")){
                    responce = input.readLine();
                    System.out.println(responce);
                }else{
                    break;
                }
            }
        }catch(IOException e){}
    }
}
