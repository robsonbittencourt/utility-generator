package com.utility.generator.classes.mappertester;

import static com.utility.generator.util.Utils.getPathFromPackageName;
import static org.apache.commons.lang3.StringUtils.isBlank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.utility.generator.clazz.part.AbstractGeneratedClass;
import com.utility.generator.clazz.part.GeneratedField;
import com.utility.generator.clazz.part.GeneratedImport;
import com.utility.generator.clazz.part.GeneratedMethod;
import com.utility.generator.clazz.part.GeneratedPackage;
import com.utility.generator.configuration.Configuration;

public class MapperTester extends AbstractGeneratedClass {

	private Class<?> originClass;
	private Configuration configuration;

	public MapperTester(Class<?> originClass, Configuration configuration) {
		this.originClass = originClass;
		this.configuration = configuration;
	}

	@Override
	public GeneratedPackage packagge() {
		return new MapperTesterPackage(originClass, configuration);
	}

	@Override
	public List<GeneratedImport> imports() {
		List<GeneratedImport> imports = new ArrayList<>();

		imports.add(new GeneratedImport(originClass));
		imports.add(new GeneratedImport(Test.class));
		imports.add(new GeneratedImport("org.junit.Assert.assertEquals", true));

		return imports;
	}

	@Override
	public String name() {
		return originClass.getSimpleName() + configuration.getClassNameSuffix();
	}

	@Override
	public List<GeneratedField> fields() {
		return Collections.emptyList();
	}

	@Override
	public List<GeneratedMethod> methods() {
		List<GeneratedMethod> methods = new ArrayList<>();

		methods.add(new MapperTesterShouldTestAllParamsMethod(originClass, configuration));

		return methods;
	}

	@Override
	public String classFilePath() {
		String path = configuration.getRootPath();

		if (isBlank(configuration.getPackageName())) {
			path += getPathFromPackageName(originClass.getPackage().getName());
		} else {
			path += getPathFromPackageName(configuration.getPackageName());
		}

		return path;
	}

}
