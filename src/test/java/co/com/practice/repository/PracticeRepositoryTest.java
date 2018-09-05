package co.com.practice.repository;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

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
import org.junit.jupiter.params.provider.ValueSource;

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

//    @InjectMocks
//    PracticeRepository practiceRepository;

    @Test
    @DisplayName("Nombre de metodo personalizado!!! :D")
    public void successTest() {
        // arrange
        String personName = "Usuario de prueba";

        // act
        String response = ""; // practiceRepository.success(personName);

        // assert
        Assert.assertNotNull(response);
        assertEquals(2,2, "Este metodo no se ve muy bien!!!");
        assertTrue(5 < 7, () -> "Assertion messages can be lazily evaluated -- "
                + "to avoid constructing complex messages unnecessarily.");
        Assert.assertEquals(2, 2);//"El consumo del servicio, ha sido exitoso, usted es Usuario de prueba", response);
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
            Thread.sleep(1);
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
    
}
