package com.arun.server.handler;

import java.io.IOException;
import java.io.UncheckedIOException;

public class UncheckedIOExceptionConverterHandler<S> extends DecoratorHandler<S>
{
    public UncheckedIOExceptionConverterHandler(Handler<S> other)
    {
        super(other);
    }

    @Override
    public void handle(S s)
    {
        try
        {
            other.handle(s);
        } catch (IOException e)
        {
            throw new UncheckedIOException(e);
        }

    }
}
