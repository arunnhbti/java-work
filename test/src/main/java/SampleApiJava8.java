import java.util.function.BiFunction;

public class SampleApiJava8<T, R>
{
    private T par0;
    private T par1;

    public <R> R add(BiFunction<T, T, R> function)
    {

        return function.apply(par0, par1);
    }
}
