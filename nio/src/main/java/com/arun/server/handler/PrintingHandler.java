package com.arun.server.handler;

import java.io.IOException;
import java.net.Socket;

public class PrintingHandler extends DecoratorHandler<Socket>
{
    public PrintingHandler(Handler<Socket> other)
    {
        super(other);
    }

    @Override
    public void handle(Socket socket) throws IOException
    {
        System.out.println("Connected to: " + socket);
        try
        {
            super.handle(socket);
        } finally
        {
            System.out.println("DisConnected from: " + socket);
        }

    }
}
