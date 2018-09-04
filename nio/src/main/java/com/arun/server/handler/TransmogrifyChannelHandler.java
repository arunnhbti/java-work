package com.arun.server.handler;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

import com.arun.server.util.Util;

public class TransmogrifyChannelHandler implements Handler<SocketChannel>
{
    @Override
    public void handle(SocketChannel sc) throws IOException
    {
        sc.connect(new InetSocketAddress(8081));
        ByteBuffer buf = ByteBuffer.allocateDirect(100);
        sc.read(buf);
        Util.transmogrify(buf);
        sc.write(buf);
    }
}
