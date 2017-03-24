package java8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

interface CheckPerson {
    boolean test(Person p);
}

public class Person {

    public enum Sex {
        MALE, FEMALE
    }

    public Person(String name) {
    		this.name = name;
    		this.birthday = LocalDate.of(1970, 4, 10);
    		this.gender = Sex.FEMALE;
    		this.emailAddress = "";
    }

    public Person(String name, LocalDate born) {
		this.name = name;
		this.birthday = born;
		this.gender = Sex.FEMALE;
		this.emailAddress = "";
    }

    public Person(String name, LocalDate born, Sex gender) {
		this.name = name;
		this.birthday = born;
		this.gender = gender;
		this.emailAddress = "";
    }

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;

    public int getAge() {
        return 2017 - birthday.getYear();
    }

    public Sex getGender() {
    		return gender;
    }

    public void printPerson() {
        System.out.println("Person(" + this.name + ", " + this.gender + ", " + this.getAge() + ")");
    }

    public static void printPersonsOlderThan(List<Person> roster, int age) {
        for (Person p : roster) {
            if (p.getAge() >= age) {
                p.printPerson();
            }
        }
    }

    public static void printPersonsWithinAgeRange(
    	    List<Person> roster, int low, int high) {
    	    for (Person p : roster) {
    	        if (low <= p.getAge() && p.getAge() < high) {
    	            p.printPerson();
    	        }
    	    }
    	}

    public static void printPersons(
    	    List<Person> roster, CheckPerson tester) {
    	    for (Person p : roster) {
    	        if (tester.test(p)) {
    	            p.printPerson();
    	        }
    	    }
    }

    public static void printPersonsWithPredicate(
    		List<Person> roster, Predicate<Person> tester) {
    	    for (Person p : roster) {
    	        if (tester.test(p)) {
    	            p.printPerson();
    	        }
    	    }
    	}

    public static void processPersons(
    	    List<Person> roster,
    	    Predicate<Person> tester,
    	    Consumer<Person> block) {
    	        for (Person p : roster) {
    	            if (tester.test(p)) {
    	                block.accept(p);
    	            }
    	        }
    	}

    public static void main(String[] args) {
    		List<Person> roster = new ArrayList<>();
    		roster.add(new Person("Laura"));
    		roster.add(new Person("John", LocalDate.of(1997, 5, 1), Person.Sex.MALE));
    		printPersons(roster, new CheckPersonEligibleForSelectiveService());
    		
    		System.out.println("Next try:");
    		printPersonsWithPredicate(roster,
    				(Person p) -> p.getGender() == Person.Sex.FEMALE
    					&& p.getAge() >= 18
    			);

    		System.out.println("Process persons:");
    		processPersons(
    			     roster,
    			     p -> p.getGender() == Person.Sex.MALE
    			         && p.getAge() >= 18
    			         && p.getAge() <= 25,
    			     p -> p.printPerson()
    			);
    }
}

class CheckPersonEligibleForSelectiveService implements CheckPerson {
    public boolean test(Person p) {
        return p.gender == Person.Sex.MALE &&
            p.getAge() >= 18 &&
            p.getAge() <= 25;
    }
}
