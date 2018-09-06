package co.com.practice.repository;


import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.Iterator;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.RepeatedTest;

import co.com.practice.MyClass;

public class MockitoTestingClass {

	@DisplayName("Compare parameters Mockito")
	@Test
	public void test1()  {
		//  create mock
		MyClass test = mock(MyClass.class);
	
	    // define return value for method getUniqueId()
	    when(test.getId()).thenReturn(17);
	    when(test.getName()).thenReturn("Fidel Jose");
	    when(test.getAddress()).thenReturn("Avenida Siempreviva 742");
	    
	    // use mock in test....
	    assertEquals("Fidel Jose", (String)test.getName());
	    assertEquals(17, test.getId());
	    assertEquals("Avenida Siempreviva 742", test.getAddress());
	}
	
	@DisplayName("Mockito Iterator")
	@Test
	public void testMockIteration() {
		Iterator<MyClass> it = mock(Iterator.class);
		MyClass obj1 = new MyClass(1, "Object1", "x");
		MyClass obj2 = new MyClass(2, "Object2", "y");
		
		when(it.next()).thenReturn(obj1).thenReturn(obj2);
		String value = it.next().getName() + "-" + it.next().getId();
		
		assertEquals("Object1-2", value);
	}
	
	@DisplayName("Comparable String Mock value")
	@Test
	public void testComparableMock() {
		Comparable<String> compareMock = mock(Comparable.class);
		when(compareMock.compareTo(anyString())).thenReturn(0);	
		
		assertEquals(0, compareMock.compareTo("texto cualquiera"));
	}
	
	@DisplayName("Comparable int Mock value")
	@Test
	public void testrComparableMockInt() {
		Comparable<Integer> compareMock = mock(Comparable.class);
		when(compareMock.compareTo(anyInt())).thenReturn(1);	
		
		assertEquals(1, compareMock.compareTo(1234567));
	}
	
	@DisplayName("Comparated Object Type")
	@Test
	public void testCompareObjectType() {
		Comparable<MyClass> c = mock(Comparable.class);
		when(c.compareTo(isA(MyClass.class))).thenReturn(0);
		
//		assertTrue(c.compareTo(new MyClass(1,"","")) == 0);
		assertEquals(c.compareTo(new MyClass(1,"","")), 0);
	}
	
	@DisplayName("Throw RunTimeException error")
	@Test
	public void testThrowExceptionMock() {
		MyClass test = mock(MyClass.class);
		when(test.getAddreesFromName("")).thenThrow(new RuntimeException());
	}
	
	@DisplayName("Mockito with spy and doReturn-when")
	@Test
	public void testDoReturn_when() {
		MyClass test = new MyClass(1,"","");
		MyClass testSpy = spy(test);
		doReturn(0).when(testSpy).isIdMajorZero(-7);
		
		assertEquals(0, testSpy.isIdMajorZero(-7));
	}
	
}
