package com.arun.server.handler;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;

public class ThreadPoolHandler extends DecoratorHandler<Socket>
{
    ExecutorService pool;
    Thread.UncaughtExceptionHandler exceptionHandler;

    public ThreadPoolHandler(Handler<Socket> other, ExecutorService pool, Thread.UncaughtExceptionHandler exceptionHandler)
    {
        super(other);
        this.pool = pool;
        this.exceptionHandler = exceptionHandler;
    }

    public ThreadPoolHandler(Handler<Socket> other, ExecutorService pool)
    {
        this(other, pool, ThreadPoolHandler::uncaughtException);
    }

    @Override
    public void handle(Socket socket)
    {
        pool.submit(new FutureTask<>(() -> {
            try
            {
                super.handle(socket);
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }, exceptionHandler));
    }

    private static void uncaughtException(Thread thread, Throwable throwable)
    {
        System.out.println("Thread: " + thread + ", Error: " + throwable);
    }

}
