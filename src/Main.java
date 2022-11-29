import java.util.*;

public class Main {





    public static void print(Set<Person> set) {
        for (Iterator<Person> iterator = set.iterator(); iterator.hasNext(); ) {
            Person p = iterator.next();
            System.out.println(p);
        }
    }

    public static void main(String[] args) {
        Set<Person> set = new TreeSet<>(Comparator.comparing(Person::getAge).reversed());
        set.add(new Person("Alena", "Veselovskih", 25));
        set.add(new Person("Roman", "Genry Robertson", 100));
        set.add(new Person("Oleg", "Veselovskih ", 110));
        set.add(new Person("Roland", "Salimr Ibn Sali Barad", 60));
        set.add(new Person("Muhammad", "Lagni Malani Rhan Ali Mali Karah", 12));
        print(set);

    }

}



