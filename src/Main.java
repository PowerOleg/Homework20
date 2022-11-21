import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static Set<Person> fillCollection() {
        Set<Person> set = new TreeSet<>();
        set.add(new Person("Alena", "Veselovskih", 25));
        set.add(new Person("Roman", "Genry Robertson", 100));
        set.add(new Person("Oleg", "Veselovskih ", 110));
        set.add(new Person("Roland", "Salimr Ibn Sali Barad", 60));
        set.add(new Person("Muhammad", "Lagni Malani Rhan Ali Mali Karah", 12));
        return set;
    }

    public static void print(Set<Person> set) {
        for (Iterator<Person> iterator = set.iterator(); iterator.hasNext(); ) {
            Person p = iterator.next();
            System.out.println(p);
        }
    }

    public static void main(String[] args) {
        PersonComparator personComparator = new PersonComparator(2);
        Set<Person> set = new TreeSet<>(personComparator);
        set.addAll(fillCollection());
        print(set);
    }
}

class PersonComparator implements Comparator<Person> {
    int maxSurnameWords;
    public PersonComparator(int maxSurnameWords) {
        this.maxSurnameWords = maxSurnameWords;
    }
    @Override
    public int compare(Person o1, Person o2) {
        String[] surnames1 = o1.getSurname().split(" ");
        String[] surnames2 = o2.getSurname().split(" ");
        int s1 = surnames1.length;
        int s2 = surnames2.length;
        if (surnames1.length > maxSurnameWords) s1 = maxSurnameWords;
        if (surnames2.length > maxSurnameWords) s2 = maxSurnameWords;
        if (s1 != s2) {
            return Integer.compare(s1, s2) * -1;
        }
        return Integer.compare(o1.getAge(), o2.getAge()) * -1;
    }
}

