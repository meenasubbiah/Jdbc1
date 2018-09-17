package com.myapp;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class TestMyApp {
	
	@Mock
	Connection con;
	
	@Rule
	MockitoRule rule=MockitoJUnit.rule();

	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
