package com.arun.test;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Arrays;

public class TimeTest {
    public static void main(String[] args) {
        final DateTimeFormatter FORMATTER
                = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ").withOffsetParsed();

        String[] dates = new String[]{
                "2019-11-29T22:58:58.999Z",
                "2019-11-29T22:58:59.999Z",
                "2019-11-29T22:59:59.999Z",
                "2019-11-29T23:59:59.999Z",
                "2019-11-30T23:59:59.999Z",
                "2019-12-31T23:59:59.999Z"
        };
        //System.out.println(x.getMillis() + "," + xPlus.getMillis());
        Arrays.stream(dates).map(FORMATTER::parseDateTime).forEachOrdered(x -> {
            DateTime xPlus = x.plusMillis(1);
            System.out.println(x + " (+1 millis) ---> " + xPlus);
        });
        dates = new String[]{
                "2019-11-29T22:58:58.990Z",
                "2019-11-29T22:58:59.901Z",
                "2019-11-29T22:59:59.123Z",
                "2019-11-29T23:59:59.468Z",
                "2019-11-30T23:59:59.876Z",
                "2019-12-31T23:59:59.001Z"
        };
        Arrays.stream(dates).map(FORMATTER::parseDateTime).forEachOrdered(x -> System.out.println(x + " > " + x.withMillisOfSecond(0)));
    }
}
