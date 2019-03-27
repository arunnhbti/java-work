import static java.util.Collections.singletonList;

import java.util.List;

public class TestGenericMethod
{
    public static void main(String[] args)
    {
        TestGenericMethod dis = new TestGenericMethod();
        String str = dis.getFirst(singletonList("String"));
        System.out.println("| String  ==> " + str);

        Integer in = dis.getFirst(singletonList("A"));
        System.out.println("| Integer ==> " + in);
    }

    private <T> T getFirst(List<Object> objs)
    {
        return (T) objs.get(0);
    }
}
