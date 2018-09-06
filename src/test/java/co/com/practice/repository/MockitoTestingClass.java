package co.com.practice.repository;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.isA;

import java.util.Iterator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.internal.progress.ArgumentMatcherStorage;

import co.com.practice.MyClass;

import static org.mockito.Mockito.*;


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
	
	@DisplayName("Verify behavior from methods")
	@Test
	public void testCallOtherMethods() {
		MyClass test = mock(MyClass.class);
		when(test.callOtherMethods(true)).thenReturn(true);
		assertTrue(test.callOtherMethods(true));
		
		test.getId();
		test.isIdMajorZero(7);
		test.isIdMajorZero(7);
		test.getAddreesFromName("");
		test.setAddress("Avenida Siempreviva 742");
		
		// verificar que el parametro del metodo 'setAddress' sea 'Avenida Siempreviva 742'
		verify(test).setAddress(ArgumentMatchers.eq("Avenida Siempreviva 742"));

		// verificar que el metodo 'isIdMajorZero' es llamado dos veces
		verify(test, times(2)).isIdMajorZero(7);
		
		// Mas alternativas para verificar el numero de llamadas por metodo.
		verify(test, never()).setAddress("Solo da error si le envia los mismo parametros al metodo");
		verify(test, atLeastOnce()).setAddress("Avenida Siempreviva 742");
		verify(test, atLeast(2)).isIdMajorZero(7);
		verify(test, atMost(2)).isIdMajorZero(7);
		verify(test, times(1)).getId();
		verify(test, times(1)).getAddreesFromName("");
		verify(test, times(1)).callOtherMethods(true);
		
		// Verificacion final, comprueba que se hicieron todas las posibles verificaciones en el metodo (en este test).
		verifyNoMoreInteractions(test);
	}
	
}
