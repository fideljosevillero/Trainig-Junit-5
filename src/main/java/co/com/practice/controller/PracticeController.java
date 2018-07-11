package co.com.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.practice.service.PracticeService;

@RestController
@RequestMapping("/api/practice")
public class PracticeController {

    @Autowired
    PracticeService practiceService;

    @RequestMapping(value = "/{personName}", method = RequestMethod.GET)
    public ResponseEntity<String> success(@PathVariable("personName") String personName) {
        return new ResponseEntity<>(practiceService.success(personName), HttpStatus.OK);
    }
}
