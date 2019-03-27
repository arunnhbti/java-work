import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Reduction
{

    public static void main(String[] args)
    {
        List<Person> persons = Arrays.asList(
                new Person("P1", new Date(), Gender.MALE, "H"),
                new Person("P2", new Date(), Gender.MALE, "H")
        );
    }

    static class Person
    {
        private String name;
        private Date dob;
        private Gender gender;
        private String state;

        Person(String name, Date dob, Gender gender, String state)
        {
            this.name = name;
            this.dob = dob;
            this.gender = gender;
            this.state = state;
        }
    }

    enum Gender
    {
        MALE, FEMALE
    }
}
