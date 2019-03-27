import java.util.UUID;

public class Test
{
    public static void main(String[] args)
    {
        final int A = (1 << 1);
        final int B = (1 << 2);
        final int C = (1 << 3);

        System.out.println(Integer.toBinaryString(A));
        System.out.println(Integer.toBinaryString(B));
        System.out.println(Integer.toBinaryString(C));

        System.out.println(Integer.toBinaryString(1 << 1 & 1 << 2));

        System.out.println(A + B + " : " + Integer.toBinaryString(A + B));
        if(((A + B) & A) == A) System.out.println("True");
        System.out.println(Integer.toBinaryString(1<<3 + 1<<2));

        //for (int i = 0; i < 5; i++) System.out.println(UUID.randomUUID().toString());
    }
}
