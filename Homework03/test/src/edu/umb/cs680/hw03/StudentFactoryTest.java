package edu.umb.cs680.hw03;


import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

public class StudentFactoryTest {

	private final String name = "Harsha Jha";
	private final String usAddr = "100 William T. Morrissey Blvd";
	private final String foreignAddr = "Delhi, India";
	private final int yrsInState = 2;
	private final int i20num = 123456789;

	@Test
	public void testCreateInStateStudent() {
		Student student = StudentFactory.createInStateStudent(name, usAddr, yrsInState);
		assertNotNull(student);
		assertThat(student.getName(),is(name));
		assertThat(student.getUsAddr(),is(usAddr));
		assertThat(student.getYrsInState(),is(yrsInState));
		assertThat(student.getStatus(), is(StudentStatus.INSTATE));
		assertNull(student.getForeignAddr());
	}

	@Test
	public void testCreateOutStateStudent() {

		Student student = StudentFactory.createOutStateStudent(name, usAddr, yrsInState);
		assertNotNull(student);
		assertThat(student.getName(),is(name));
		assertThat(student.getUsAddr(),is(usAddr));
		assertThat(student.getYrsInState(),is(yrsInState));
		assertThat(student.getStatus(),is(StudentStatus.OUTSTATE));
		assertNull(student.getForeignAddr());
	}

	@Test
	public void testCreateIntlStudent() {
		Student student = StudentFactory.createIntlStudent(name,i20num, usAddr, yrsInState,foreignAddr);
		assertNotNull(student);
		assertThat(student.getName(),is(name));
		assertThat(student.getI20num(),is(i20num));
		assertThat(student.getUsAddr(),is(usAddr));
		assertThat(student.getYrsInState(),is(yrsInState));
		assertThat(student.getForeignAddr(),is(foreignAddr));		
		assertThat(student.getStatus(),is(StudentStatus.INTL));
		
	}
}