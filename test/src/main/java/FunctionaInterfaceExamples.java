import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FunctionaInterfaceExamples
{
    public static void main(String[] args)
    {

        // One
        List<Person> persons = getPersons();
        Collections.sort(persons, new Comparator<Person>()
        {
            @Override
            public int compare(Person o1, Person o2)
            {
                return o1.getName().length() - o2.getName().length();
            }
        });
        System.out.println(Arrays.deepToString(persons.toArray()));

        // Two
        persons = getPersons();
        Collections.sort(persons, Comparator.comparing(o -> o.getName().length()));
        System.out.println(Arrays.deepToString(persons.toArray()));

        // Three
        persons = getPersons();
        Collections.sort(persons, (o1, o2) -> o1.getName().length() - o2.getName().length());
        System.out.println(Arrays.deepToString(persons.toArray()));
    }

    private static List<Person> getPersons()
    {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Arun4444"));
        personList.add(new Person("Arun22"));
        personList.add(new Person("Arun333"));
        personList.add(new Person("Arun1"));
        return personList;
    }

    static class Person implements Comparable<Person>
    {
        private String name;

        Person(String name)
        {
            this.name = name;
        }

        String getName()
        {
            return this.name;
        }

        @Override
        public String toString()
        {
            return this.getName();
        }

        @Override
        public int compareTo(Person o)
        {
            return this.getName().length() - o.getName().length();
        }
    }
}
