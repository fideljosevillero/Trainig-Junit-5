package co.com.practice.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PracticeRepositoryTest {

    @InjectMocks
    PracticeRepository practiceRepository;

    @Test
    public void successTest() {
        // arrange
        String personName = "Usuario de prueba";

        // act
        String response = practiceRepository.success(personName);

        // assert
        Assert.assertNotNull(response);
        Assert.assertEquals("El consumo del servicio, ha sido exitoso, usted es Usuario de prueba", response);
    }
}
