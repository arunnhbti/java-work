import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Key
{
    List<String> ids = new ArrayList<String>();
    public Key(String... strings) {
        ids = Arrays.asList(strings);
    }
}
