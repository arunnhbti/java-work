//  **********************************************************************
//  Copyright (c) 2017 Ericsson Telekommunikation GmbH.
//  All rights reserved.
//  The Copyright to the computer program(s) herein is the property of
//  Ericsson Telekommunikation GmbH.
//  The program(s) may be used and/or copied with the written permission
//  from Ericsson Telekommunikation GmbH or in accordance with the terms
//  and conditions stipulated in the agreement/contract under which the
//  program(s) have been supplied.
//  **********************************************************************

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class TestThreadMultipleLock
{

    public static void main(String[] args)
    {
        List<String> keys = new ArrayList<String>()
        {
            {
                this.add("party");
                this.add("customer");
                this.add("contract");
            }
        };
        TestService testService = new TestService();
        ExecutorService exec = Executors.newFixedThreadPool(10);

        for (final MyMutableInteger index = new MyMutableInteger(0); index.getValue() <= 5; )
        {
            exec.submit(
                    new Callable<FutureTask>()
                    {
                        @Override
                        public FutureTask call() throws Exception
                        {

                            testService.increment(keys.get(index.getValue()%3));

                            int val = index.getValue() + 1;
                            index.setValue(val);

                            return new FutureTask(this);
                        }
                    }
            );
        }
        exec.shutdown();
    }
}
