package org.tupurpcheung.learn.jdk.io.bio;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("127.0.0.1",9999);
        PrintStream printStream = new PrintStream(socket.getOutputStream());

        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("请说：");
            String s = sc.nextLine();
            if(".exit".equalsIgnoreCase(s)){
                socket.shutdownOutput();
                System.out.println("拜拜");
                break;
            }
            printStream.println(s);
            printStream.flush();
        }



    }
}
