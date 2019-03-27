import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TestMod
{

    public static void main(String[] args)
    {

        List<String> list = new ArrayList<String>()
        {
            {
                this.add("a");
                this.add("a2");
                this.add("a3");
                this.add("a4");
            }
        };

        /*Optional.ofNullable(list)
                .map(
                        strings -> strings.removeIf(s -> s.equals("a2"))
                );
        System.out.println(Arrays.deepToString(list.toArray()));*/
        /*

        for(String s : list) {
            if(s.equals("a4")) {
                list.remove(s);

            }
        }
*/
    }
}
