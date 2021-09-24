package org.tupurpcheung.learn.jdk.io.bio;

import java.io.*;
import java.net.Socket;

public class ServerRunnableTarget implements Runnable{

    private Socket socket = null;

    public ServerRunnableTarget(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

            try {
                InputStream inputStream = socket.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String msg = null;
                while ((msg = bufferedReader.readLine()) != null){
                    System.out.println(msg);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


    }
}
