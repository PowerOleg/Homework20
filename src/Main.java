import java.util.*;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Roland", "Salimr Ibn Sali Barad", 60);
        Person person2 = new Person("Roman", "Genry Robertson", 100);
        PersonComparator personComparator = new PersonComparator();
        PersonComparator2 personComparator2 = new PersonComparator2();
        Set<Person> set = new TreeSet<Person>(personComparator.thenComparing(personComparator2));

        set.add(new Person("Alena", "Veselovskih", 25));
        set.add(person2);
        set.add(new Person("Oleg", "Veselovskih ", 30));
        set.add(person1);
        for (Iterator<Person> iterator = set.iterator(); iterator.hasNext(); ) {
            Person p = iterator.next();
            System.out.println(p);
        }
    }
}
class PersonComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
       String[] surnames1 = o1.getSurname().split(" ");
       String[] surnames2 = o2.getSurname().split(" ");
       return Integer.compare(surnames1.length, surnames2.length) * -1;
    }
}
class PersonComparator2 implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return Integer.compare(o1.getAge(), o2.getAge()) * -1;
    }
}
