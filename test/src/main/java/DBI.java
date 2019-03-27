import java.util.HashMap;
import java.util.Map;

public class DBI
{
    private Map<String, String> dbi = new HashMap<String, String>()
    {{
        this.put("abc", "xyz");
        this.put("cba", "zyx");
    }};

    public static void main(String[] args)
    {
        new DBI().verify();
    }

    private void verify()
    {
        System.out.println(dbi.toString());
    }
}
