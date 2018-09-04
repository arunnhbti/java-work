package com.arun.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.arun.server.handler.Handler;
import com.arun.server.handler.PrintingHandler;
import com.arun.server.handler.TransmogrifyHandler;

public class SingleThreadedBlockingServer
{
    public static void main(String[] args) throws IOException
    {
        ServerSocket server = new ServerSocket(8081);
        Handler<Socket> handler = new PrintingHandler(new TransmogrifyHandler());
        while (true)
        {
            Socket socket = server.accept();
            handler.handle(socket);
        }
    }

}
