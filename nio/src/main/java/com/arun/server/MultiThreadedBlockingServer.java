package com.arun.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;

import com.arun.server.handler.Handler;
import com.arun.server.handler.PrintingHandler;
import com.arun.server.handler.ThreadPoolHandler;
import com.arun.server.handler.TransmogrifyHandler;

public class MultiThreadedBlockingServer
{
    public static void main(String[] args) throws IOException
    {
        try(ServerSocket server = new ServerSocket(8081))
        {
            System.out.println("| SERVER STARTED");
            System.out.println("| PORT 8081");
            Handler<Socket> handler =
                    new ThreadPoolHandler(
                            new PrintingHandler(
                                    new TransmogrifyHandler()),
                            Executors.newFixedThreadPool(25)
                    );

            while (true)
            {
                Socket socket = server.accept();
                handler.handle(socket);
            }
        } finally
        {
            System.out.println("|| SERVER STOPPED");
        }
    }


}
