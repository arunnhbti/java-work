package com.arun.server;

import java.io.IOException;
import java.net.Socket;

public class NastyConnection
{
    public static void main(String[] args)
    {
        Socket[] connections = new Socket[1_000];
        int i = 0;
        try
        {
            while (i < connections.length)
            {
                connections[i++] = new Socket("localhost", 8081);
            }
        } catch (IOException e)
        {
            System.out.println("Failed to establish connection: " + i);
        }
    }
}
