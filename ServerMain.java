package com.sachet.company;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.net.ServerSocket;

public class ServerMain {
    ExecutorService thpool = Executors.
            newFixedThreadPool(2000 );
    public static void main(String[] args) {
        Thread t1;
        ServerMain mn = new ServerMain();
        try(ServerSocket serversocket = new ServerSocket
                (5000)){
            int i=0;
            while(true){
                mn.thpool.submit(
                        (new TPimplement(serversocket
                .accept())));
//                t1 = new Thread(new TPimplement(serversocket.accept()));
//                t1.start();
//                Thread.sleep(100);
//                t1.interrupt();
            }
//            mn.thpool.shutdown();
        }catch(Exception e){}
    }
}
