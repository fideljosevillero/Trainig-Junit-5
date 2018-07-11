package co.com.practice.repository;

import org.springframework.stereotype.Repository;

@Repository
public class PracticeRepository {

    public String success(String personName) {
        return String.format("El consumo del servicio, ha sido exitoso, usted es %s", personName);
    }
}
