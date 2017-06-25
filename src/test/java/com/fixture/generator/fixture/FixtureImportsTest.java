package com.fixture.generator.fixture;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.fixture.generator.base.clazz.Person;
import com.fixture.generator.clazz.part.GeneratedImports;

public class FixtureImportsTest {

	private GeneratedImports method;

	@Before
	public void setUp() {
		method = new FixtureImports(Person.class);
	}

	@Test
	public void shouldImportThreeClasses() {
		assertEquals(3, method.classesToImport().size());
	}

	@Test
	public void shouldImportNecessaryClasses() {
		List<Class<?>> classesToImport = method.classesToImport();

		assertEquals(List.class, classesToImport.get(0));
		assertEquals(ArrayList.class, classesToImport.get(1));
		assertEquals(Person.class, classesToImport.get(2));
	}

}
