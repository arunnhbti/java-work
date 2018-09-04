package com.arun.server.util;

import java.nio.ByteBuffer;

public class Util
{
    public static int transmogrify(int data)
    {
        return Character.isLetter(data) ? data ^ ' ' : data;
    }

    public static ByteBuffer transmogrify(ByteBuffer byBuffer)
    {
        byBuffer.flip();
        return byBuffer;
    }
}
