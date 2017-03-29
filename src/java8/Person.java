package java8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import java.io.*;
import java.nio.file.FileSystemNotFoundException;

class CheckPersonFemaleOlderThan implements CheckPerson {
	private int age;

	CheckPersonFemaleOlderThan(int age) {
		this.age = age;
	}

	public boolean test(Person p) {
		return (p.gender == Person.Sex.FEMALE && p.getAge() >= age);
	}
}

interface WriterFactory {
	public Writer getWriter() throws IOException;
}

public class Person {

    public enum Sex {
        MALE, FEMALE
    }

    public Person(String name) {
    		this.name = name;
    		this.birthday = LocalDate.of(1970, 4, 15);
    		this.gender = Sex.FEMALE;
    }

    public Person(String name, LocalDate born) {
		this.name = name;
		this.birthday = born;
		this.gender = Sex.FEMALE;
    }

    public Person(String name, LocalDate born, Sex gender) {
		this.name = name;
		this.birthday = born;
		this.gender = gender;
    }

    public Person(String name, LocalDate born, Sex gender, WriterFactory writerFactory) {
		this.name = name;
		this.birthday = born;
		this.gender = gender;
		this.writerFactory = writerFactory;
    }

    WriterFactory writerFactory;
    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;

    public int getAge() {
        return LocalDate.now().getYear() - birthday.getYear();
    }

    public void writeInfoToDataStore() throws IOException {
    	    Writer writer = null;
    	    try {
    			writer = writerFactory.getWriter();
    			writer.write("" + name + ", " + getAge());
    		} catch (FileSystemNotFoundException fnfe) {
    			// TODO
    		} catch (IOException ioe) {
    			// TODO
    		} finally {
    			if (writer != null)
    				writer.close();
    		}
    		
    }

    public void printPerson() {
        System.out.println("Person(" + name + ", " + getAge() + ", " + gender + ")");
    }

    public static void printPersonsOlderThan(List<Person> roster, int age) {
        for (Person p : roster) {
            if (p.getAge() >= age) {
                p.printPerson();
            }
        }
    }

    public static void printPersonsBetween(List<Person> roster, int ageFrom, int ageTo) {
        for (Person p : roster) {
            if (p.getAge() >= ageFrom && p.getAge() < ageTo) {
                p.printPerson();
            }
        }
    }

    public static void printPersonsWithSelection(List<Person> roster, Predicate<Person> checker) {
        for (Person p : roster) {
            if (checker.test(p)) {
                p.printPerson();
            }
        }
    }

    public static void processPersonsWithSelection(
    		List<Person> roster,
    		Predicate<Person> checker,
    		Consumer<Person> action) {
        for (Person p : roster) {
            if (checker.test(p)) {
                action.accept(p);
            }
        }
    }

    public static void main(String[] args) {
    		List<Person> roster = new ArrayList<Person>();
    		roster.add(new Person("Anna"));
    		roster.add(new Person("John", LocalDate.of(1998, 4, 20), Person.Sex.MALE));
    		
    		Person.printPersonsOlderThan(roster, 18);
    		
    		System.out.println("between:");
    		Person.printPersonsBetween(roster, 18, 25);
    		
    		System.out.println("CheckPerson interface:");
    		CheckPerson myChecker = new CheckPersonFemaleOlderThan(40);
    		Person.printPersonsWithSelection(roster, myChecker);
    		
    		System.out.println("CheckPerson interface (2):");
    		
    		Person.printPersonsWithSelection(roster, new CheckPerson() {
    			public boolean test(Person p) {
    				return p.getAge() < 40 && p.gender == Person.Sex.MALE;
    			}
    		});
    		
    		System.out.println("CheckPerson using lambda expression");
    		
    		Person.printPersonsWithSelection(roster,
    			(Person p) -> p.getAge() < 40 && p.gender == Person.Sex.MALE
    			// boolean test(Person p) { return p.getAge() < 40 && p.gender == Person.Sex.MALE; }
    		);
    		
    		System.out.println("Two lambda expressions");
    		
    		Person.processPersonsWithSelection(roster,
    			(Person p) -> p.getAge() >= 40 && p.gender == Person.Sex.FEMALE,
    			(Person p) -> {
    				int age = p.getAge();
    				System.out.println(p.name + ": " + age);
    			});
    }
}

interface CheckPerson extends Predicate<Person> {}


