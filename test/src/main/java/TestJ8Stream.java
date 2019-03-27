import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestJ8Stream
{

    List<String> list = new ArrayList<String>() {
        {
            this.add("abc");
            this.add("bcd");
            this.add("def");
            this.add("efgh");
        }
    };

    public static void main(String[] args)
    {
        TestJ8Stream myObj = new TestJ8Stream();
        myObj.list.stream().filter((t) -> t.length() == 4).map(String::length).collect(Collectors.toList());
    }
}
