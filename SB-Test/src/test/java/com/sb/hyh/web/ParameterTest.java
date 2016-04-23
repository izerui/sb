package com.sb.hyh.web;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParameterTest {
	private String name;
	private boolean result;

	public ParameterTest(String name, boolean result) {
		super();
		this.name = name;
		this.result = result;
	}

	@Parameters
	public static Collection<?> data() {
		return Arrays.asList(new Object[][] { { "小明2", true }, { "坏", false }, { "莉莉", false }, });
	}

	@Test
	public void test() {
		assertTrue(name.contains("小") == result);
	}
}