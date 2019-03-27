import static java.lang.System.out;

import java.time.Instant;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicReference;

public class CompletableFutureExample2
{
    private final AtomicReference<CompletableFuture<Boolean>> futureAtomicReference = new AtomicReference<>();

    public static void main(String[] args)
    {
        final Instant start = Instant.now();
        out.println("Async Start: " + start);
        final CompletableFutureExample2 target = new CompletableFutureExample2();
        target.runAsync();
        target.reRunAsync();
        final Instant end = Instant.now();
        out.println("Async  End: " + end);

    }

    private void runAsync()
    {
        CompletableFuture<Boolean> future = CompletableFuture
                .supplyAsync(this::waitInfinite)
                .exceptionally(ex -> {
                    postCompletion(false);
                    return false;
                });
        futureAtomicReference.compareAndSet(null, future);
    }

    private void reRunAsync()
    {
        final CompletableFuture<Boolean> completableFuture = futureAtomicReference.get();
        if (Objects.nonNull(completableFuture) && !completableFuture.isDone())
        {
            out.println("Still executing.");
            out.println("I'm going to completed it manually.");
            completableFuture.complete(false);
        }
        runAsync();
    }

    private Boolean waitInfinite()
    {
        //In case my operation succeed gracefully, it would be returning with True.

        while (true)
            out.println("Waiting!");
    }

    private void postCompletion(boolean isCompleted)
    {
        if (isCompleted) out.println("Job completed successfully.");
        else out.println("Job completed exceptionally/manually.");
    }
}
