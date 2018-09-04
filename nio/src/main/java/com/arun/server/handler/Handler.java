package com.arun.server.handler;

import java.io.IOException;

@FunctionalInterface
public interface Handler<S>
{
    void handle(S s) throws IOException;
}
