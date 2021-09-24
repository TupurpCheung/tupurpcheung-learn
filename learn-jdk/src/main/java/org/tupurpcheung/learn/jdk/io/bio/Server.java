package org.tupurpcheung.learn.jdk.io.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        System.out.println("服务端启动");
        HandlerSocketServerPool pool = new HandlerSocketServerPool(3,5);
        ServerSocket serverSocket = new ServerSocket(9999);
        while (true){
            Socket accept = serverSocket.accept();
            pool.execute(new ServerRunnableTarget(accept));
        }


    }
}
