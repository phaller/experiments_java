package java8;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.time.LocalDate;

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

}
