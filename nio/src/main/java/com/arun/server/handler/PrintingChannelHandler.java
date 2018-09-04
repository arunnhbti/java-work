package com.arun.server.handler;

import java.io.IOException;
import java.net.Socket;
import java.nio.channels.SocketChannel;

public class PrintingChannelHandler extends DecoratorHandler<SocketChannel>
{
    public PrintingChannelHandler(Handler<SocketChannel> other)
    {
        super(other);
    }

    @Override
    public void handle(SocketChannel sc) throws IOException
    {
        System.out.println("Connected to: " + sc);
        try
        {
            super.handle(sc);
        } finally
        {
            System.out.println("DisConnected from: " + sc);
        }

    }
}
