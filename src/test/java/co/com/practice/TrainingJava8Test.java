package co.com.practice;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
	public void testgetEvenNumbers1() {
		List<Integer> actual = objTest.getEvenNumbers(lista);
		List<Integer> expected = new ArrayList<>(Arrays.asList(4,6,8,22));
		assertArrayEquals(expected.toArray(), actual.toArray());
	}
	
	@Test
	@DisplayName(value = "count item at list - Java 8")
	public void testgetEvenNumbers2() {
		List<Integer> lista = objTest.getEvenNumbers(this.lista);
		int actual = lista.size();
		assertEquals(4, actual);
	}
	
	
	@DisplayName("Get 8 percent")
	@Test
	public void testGet8Percent() {
		float actual = objTest.get8Percent(100);
		assertEquals(8f, actual);
	}
	
	@Test
	@DisplayName("to get salary free (salary - 8%)")
	public void testGetFreeSalary() {
		float actual = objTest.getFreeSalary(3000);
		assertEquals(2760, actual);
	}
	
}
