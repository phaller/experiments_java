package java8;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TestPerson {

	/* Must be runnable without internet connection! */
	@Test
	public void testOutput() {
		StringWriter stringWriter = new StringWriter();
		
		WriterFactory testFactory = new WriterFactory() {
			public Writer getWriter() {
				return stringWriter;
			}
		};

		Person p = new Person(
				"Jim",
				LocalDate.of(1970, 3, 2),
				Person.Sex.MALE,
				testFactory);

		try {
			p.writeInfoToDataStore();
		} catch (IOException ioe) {
			// test fails if exception is caught
			fail();
		}

		// check for correct output
		assertEquals(stringWriter.toString(), "Jim, 47");
	}

	@Test
	public void testMethodReference() {
		List<Person> roster = new ArrayList<Person>();
		roster.add(new Person("Anna"));
		roster.add(new Person("John", LocalDate.of(1998, 4, 20), Person.Sex.MALE));
		roster.add(new Person("Paul", LocalDate.of(1990, 9, 10), Person.Sex.MALE));
		roster.add(new Person("Pauline", LocalDate.of(1988, 2, 12), Person.Sex.FEMALE));

		Person[] pa = roster.toArray(new Person[roster.size()]);

		// here, we are using a method reference:
		Arrays.sort(pa, Person::compareByAge);

		// two lists
		// 0, 1, 2, 3
		// 1, 2, 3, 4
		List<Person> fromFirst = new ArrayList<>();
		List<Person> fromSecond = new ArrayList<>();
		fromFirst.add(pa[0]);
		for (int i = 1; i < pa.length - 1; i++) {
			fromFirst.add(pa[i]);
			fromSecond.add(pa[i]);
		}
		fromSecond.add(pa[pa.length-1]);

		List<Boolean> combined = new ArrayList<>();
		for (int i = 0; i < pa.length - 1; i++) {
			combined.add(fromFirst.get(i).getAge() <= fromSecond.get(i).getAge());
		}

		// Here, we are using a Hamcrest matcher (part of JUnit)
		// See https://github.com/junit-team/junit4/wiki/assertions
		assertThat(combined, everyItem(is(true)));
	}

}
