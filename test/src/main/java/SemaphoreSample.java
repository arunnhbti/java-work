import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreSample
{
    Semaphore a = new Semaphore(1);
    Semaphore b = new Semaphore(1);

    protected void a() throws Throwable
    {
        a.acquire();
        System.out.println("inside a.");
        a.release();
    }

    protected void b() throws Throwable
    {
        a.acquire();
        System.out.println("inside b.");
    }

    protected void c() throws Throwable
    {
        System.out.println("inside c.");
    }

    public static void main(String[] args) throws Exception
    {
        SemaphoreSample sample = new SemaphoreSample();
        ExecutorService service = Executors.newFixedThreadPool(5);
        service.submit(() -> {
            try
            {
                sample.a();
            } catch (Throwable throwable)
            {
                throwable.printStackTrace();
            }
        });
        service.submit(() -> {
            try
            {
                sample.b();
            } catch (Throwable throwable)
            {
                throwable.printStackTrace();
            }
        });
        service.submit(() -> {
            try
            {
                sample.c();
            } catch (Throwable throwable)
            {
                throwable.printStackTrace();
            }
        });


    }
}
