package com.arun.test;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        Instant start = Instant.now();
        System.out.println(Instant.now() + " : " + start.getNano());
        Thread.sleep(10);
        Instant end = Instant.now();
        System.out.println(end.getNano());
        System.out.println(ChronoUnit.MILLIS.between(start, end));
    }
}
