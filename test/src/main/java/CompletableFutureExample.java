import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

public class CompletableFutureExample
{
    public static void main(String[] args)
    {
        final Instant start = Instant.now();
        System.out.println("Async Start: " + start);
        IntStream.range(1, 100).forEach(value ->
                CompletableFuture.runAsync(() -> CompletableFutureExample.myWaitingMethod(value))
                        .thenRun(() -> CompletableFutureExample.myWaitingMethod(value))
                        .thenRun(() -> CompletableFutureExample.myWaitingMethod(value))

        );
        final Instant end = Instant.now();
        System.out.println("Async  End: " + end);
        System.out.println("Total Time with CompletableFuture: " + Duration.between(start, end));
        System.out.println("=================================");
        System.out.println("Sync Start: " + end);
        IntStream.range(1, 100).forEach(value -> {
                    CompletableFutureExample.myWaitingMethod(value);
                    CompletableFutureExample.myWaitingMethod(value);
                    CompletableFutureExample.myWaitingMethod(value);
                }
        );

        final Instant end2 = Instant.now();
        System.out.println("Sync Start: " + end2);
        System.out.println("Total Time with conventional sync methodology: " + Duration.between(end, end2));

    }

    private static int myWaitingMethod(int value)
    {
        try
        {
            Thread.sleep(100);
        }
        catch (InterruptedException e)
        {
            //
        }
        return value;
    }
}
