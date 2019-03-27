package com.arun.server;

import java.io.IOException;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

import com.arun.server.handler.Handler;
import com.arun.server.handler.PrintingChannelHandler;
import com.arun.server.handler.TransmogrifyChannelHandler;

public class SocketChannelBlockingServer
{
    public static void main(String[] args) throws IOException
    {
        try (ServerSocketChannel ssc = ServerSocketChannel.open())
        {
            System.out.println("| SERVER STARTED...");
            System.out.println("| PORT 8081");
            Handler<SocketChannel> handler = new PrintingChannelHandler(new TransmogrifyChannelHandler());

            while (true)
            {
                SocketChannel socket = ssc.accept();
                handler.handle(socket);
            }
        } finally
        {
            System.out.println("| SERVER STOPPED");
        }
    }


}
