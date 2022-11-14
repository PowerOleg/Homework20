import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Person<String> person1 = new Person("Roland", "Salimr Ibn Sali Barad", 60);
        Person<String> person2 = new Person("Roman", "Genry Robertson", 100);
        PersonComparator personComparator = new PersonComparator(2);
        PersonComparator2 personComparator2 = new PersonComparator2();
        Set<Person<String>> set = new TreeSet<>(personComparator.thenComparing(personComparator2));
        set.add(new Person<String>("Alena", "Veselovskih", 25));
        set.add(person2);
        set.add(new Person<String>("Oleg", "Veselovskih ", 30));
        set.add(person1);
        for (Iterator<Person<String>> iterator = set.iterator(); iterator.hasNext(); ) {
            Person p = iterator.next();
            System.out.println(p);
        }
    }
}

class PersonComparator implements Comparator<Person<String>> {
    int maxSurnameWords;
    public PersonComparator(int maxSurnameWords) {
        this.maxSurnameWords = maxSurnameWords;
    }
    @Override
    public int compare(Person<String> o1, Person<String> o2) {
        String[] surnames1 = o1.getSurname().split(" ");
        String[] surnames2 = o2.getSurname().split(" ");
        int s1 = surnames1.length;
        int s2 = surnames2.length;
        if (surnames1.length > maxSurnameWords) s1 = 2;
        if (surnames2.length > maxSurnameWords) s2 = 2;
        return Integer.compare(s1, s2) * -1;
    }
}

class PersonComparator2 implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return Integer.compare(o1.getAge(), o2.getAge()) * -1;
    }
}
