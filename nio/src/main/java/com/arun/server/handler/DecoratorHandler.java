package com.arun.server.handler;

import java.io.IOException;

public abstract class DecoratorHandler<S> implements Handler<S>
{
    Handler<S> other;

    public DecoratorHandler(Handler<S> other)
    {
        this.other = other;
    }

    @Override
    public void handle(S s) throws IOException
    {
        other.handle(s);
    }
}
