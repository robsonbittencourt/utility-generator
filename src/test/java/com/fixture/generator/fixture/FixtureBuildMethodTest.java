package com.fixture.generator.fixture;

import static org.junit.Assert.assertEquals;

import org.jboss.forge.roaster.model.Visibility;
import org.junit.Before;
import org.junit.Test;

import com.fixture.generator.base.clazz.Person;
import com.fixture.generator.clazz.part.GeneratedMethod;

public class FixtureBuildMethodTest {

	private GeneratedMethod method;

	@Before
	public void setUp() {
		method = new FixtureBuildMethod(Person.class);
	}

	@Test
	public void shouldBeAPublicMethod() {
		assertEquals(Visibility.PUBLIC, method.visibility());
	}

	@Test
	public void shouldReturnOriginClass() {
		assertEquals("Person", method.returnType());
	}

	@Test
	public void methodNameShoudlBeBuild() {
		assertEquals("build", method.getName());
	}

	@Test
	public void shouldReturnTheBodyOfTheMethod() {
		assertEquals("return person;", method.getBody());
	}

}
