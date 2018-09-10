package co.com.practice;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ejb.EJB;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TrainingJava8Test {
	
	private static List<Integer> lista;
	
	private static TrainingJava8 objTest;
	
	@BeforeAll
	public static void initValues() {
		System.out.println("entra al beforeAll");
		lista = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,22));
		objTest = new TrainingJava8();
	}
	
	@Test
	@DisplayName(value = "Validate even number - Java 8")
	public void testTraining1() {
		List<Integer> actual = objTest.getEvenNumbers(lista);
		List<Integer> expected = new ArrayList<>(Arrays.asList(4,6,8,22));
		assertArrayEquals(expected.toArray(), actual.toArray());
	}
	
	@Test
	@DisplayName(value = "test 1 - Java 8")
	public void testTraining2() {
		
	}
	
}
