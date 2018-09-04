package com.arun.server.handler;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UncheckedIOException;
import java.net.Socket;

import com.arun.server.util.Util;

public class TransmogrifyHandler implements Handler<Socket>
{
    @Override
    public void handle(Socket socket)
    {
        try (
                socket;
                InputStream in = socket.getInputStream();
                OutputStream out = socket.getOutputStream())

        {
            int data;
            while ((data = in.read()) != -1)
            {
                out.write(Util.transmogrify(data));
            }
        } catch (IOException e)
        {
            throw new UncheckedIOException(e);
        }
    }
}
