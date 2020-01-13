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
