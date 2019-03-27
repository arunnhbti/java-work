public class ConsumeSampleApiJava8
{

    public static void main(String[] args)
    {
        System.out.println(">> " + new SampleApiJava8<String, Integer>().add((s0, s1) -> {
            return Integer.parseInt(s0) + Integer.parseInt(s1);
        }));

        System.out.println(">> " + new SampleApiJava8<String, String>().add((s0, s1) -> {
            return s0 + s1;
        }));

    }
}
