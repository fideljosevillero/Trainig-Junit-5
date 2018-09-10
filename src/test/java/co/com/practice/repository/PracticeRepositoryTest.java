package co.com.practice.repository;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.util.EnumSet;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

//@RunWith(MockitoJUnitRunner.class)
@DisplayName("Test de la Clase PracticeRepositoryTest")
/*
 * @TestInstance(Lifecycle.PER_CLASS)  
 * Cambia el comportamiento por defecto de los test, 
 * y permite hacer test de los métodos con la misma instancia de clase (object)
 * reset variables con @BeforeAll y @AfterAll
*/
@TestInstance(Lifecycle.PER_CLASS) 
public class PracticeRepositoryTest {
	
    @Test
    @DisplayName("Nombre de metodo personalizado!!! :D")
    public void successTest() {
        // arrange
        String personName = "Usuario de prueba";

        // act
        String response = ""; // practiceRepository.success(personName);
        int valueMethodToTest = 2; 
        
        // assert 
        Assert.assertNotNull(response);
        assertEquals(2,2, "Este metodo no se ve muy bien!!!");
        assertTrue(5 < 7, () -> "Assertion messages can be lazily evaluated -- "
                + "to avoid constructing complex messages unnecessarily.");
        Assert.assertEquals(2, valueMethodToTest);//"El consumo del servicio, ha sido exitoso, usted es Usuario de prueba", response);
    }
    
    @Test
    @DisplayName("Method Exception!!!")
    @RepeatedTest(value = 10, name= "DisplayName => {displayName} iteracion => {currentRepetition}/ Total => {totalRepetitions}")
    void exceptionTesting() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("a message");
        });
        assertEquals("a message", exception.getMessage());
    }
    
    @ParameterizedTest
    @ValueSource(strings = { "carro", "radar" })
    // @ValueSource(ints = { 2,5,7,11 })
    void trainingTest(String parameterValue){
    	System.out.println("EL VALOR DEL PARAMETRO =>" + parameterValue );
    	int expected = 5;
    	assertEquals(expected, parameterValue.length());
    }
    
    @Test
    //@Disabled
    @DisplayName("Test Time Out")
    // Conditions
    // @Target(ElementType.METHOD)
    // @Retention(RetentionPolicy.RUNTIME)
    @EnabledOnOs({OS.WINDOWS, OS.LINUX})
    @DisabledOnOs(OS.MAC)
    @EnabledOnJre(value= JRE.JAVA_8)
    //@DisabledOnJre(value= JRE.JAVA_8)
    //*** 3.7.3. System Property Conditions
    //@EnabledIfSystemProperty(named = "os.arch", matches = ".*64.*")//JVM system property => https://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html
    //@DisabledIfSystemProperty(named = "os.arch", matches = ".*64.*")
    @EnabledIfEnvironmentVariable(named="OS", matches=".*_NT")
    //@DisabledIfEnvironmentVariable(named="OS", matches=".indows_NT")
    @Tag("TagName")
    public void timeoutExceededWithPreemptiveTermination() {
        // The following assertion fails with an error message similar to:
        // execution timed out after 10 ms
        assertTimeoutPreemptively(ofMillis(10), () -> {
            // Simulate task that takes more than 10 ms.
            //Thread.sleep(1);
        });
    }
    
    @Test
    @DisplayName("Assume method!!!")
    void testOnlyOnDeveloperWorkstation() {
//        assumeTrue("DEV".equals(System.getenv("ENV")),
    	assumeTrue("2".equals("wed"),
            () -> "Aborting test: not on developer workstation");
        // remainder of test
    }
    
    @ParameterizedTest
    @DisplayName("Parameterized method")
    @EnumSource(value = TimeUnit.class, names = { "DAYS", "HOURS", "MICROSECONDS" })
    void testWithEnumSourceInclude(TimeUnit timeUnit) {
        assertTrue(EnumSet.of(TimeUnit.DAYS, TimeUnit.HOURS, TimeUnit.MICROSECONDS).contains(timeUnit));
    }
    
    @DisplayName("Send method as Paramater")
    @ParameterizedTest
    @MethodSource("stringProvider")
    void testMethodSource(String argument) {
    	System.out.println("Parametro testMethodSource => " + argument);
        assertNotNull(argument);
    }
    static Stream<String> stringProvider() {
        return Stream.of("value 1", "value 2");
    }
//    @ParameterizedTest
//    @MethodSource("stringIntAndListProvider")
//    void testWithMultiArgMethodSource(String str, int num, List<String> list) {
//        assertEquals(3, str.length());
//        assertTrue(num >=1 && num <=2);
//        assertEquals(2, list.size());
//    }
//    static Stream<Arguments> stringIntAndListProvider() {
//        return Stream.of(
//            arguments("foo", 1, Arrays.asList("a", "b")),
//            arguments("bar", 2, Arrays.asList("x", "y"))
//        );
//    }
    
    @DisplayName("Csv Sources Parameter")
    @ParameterizedTest
    @CsvSource({ "foo, 1", "bar-editado, 2", "'baz, qux', 3" })
    void testCsvSource(String first, int second) {
        assertNotNull(first);
        System.out.println("testCsvSource value => " + first + " y " + second);
        assertNotEquals(0, second);
    }
    @DisplayName("Csv Resource File Parameter")
    @ParameterizedTest
    @CsvFileSource(resources = "/two-column.csv", numLinesToSkip = 1)
    void testWithCsvFileSource(String first, int second) {
        assertNotNull(first);
        System.out.println("first value => " + first);
        System.out.println("second value => " + second);
        assertNotEquals(0, second);
    }
    
//*** PENDIENTES
//    @ParameterizedTest
//    @ArgumentsSource(MyArgumentsProvider.class)
    
    // 3.14.5. Argument Aggregation
    
}
