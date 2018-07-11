package co.com.practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.practice.repository.PracticeRepository;

@Service
public class PracticeService {

    @Autowired
    PracticeRepository practiceRepository;

    public String success(String personName) {
        return practiceRepository.success(personName);
    }
}
