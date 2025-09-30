package com.dev.FraudDetection.Controller;

import com.dev.FraudDetection.model.Person;
import com.dev.FraudDetection.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {

    private final PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository _personRepository) {
        this.personRepository = _personRepository;
    }


    @GetMapping("/persons")
    public ResponseEntity<List<Person>> getAllTransactions() {
        List<Person> transactions = personRepository.findAll();
        return ResponseEntity.ok(transactions);
    }

    @PostMapping("/addPerson")
    public Person createPerson(@RequestBody Person person) {
        return personRepository.save(person);
    }
    @PostMapping("/deletePerson/{id}")
    public String deletePerson(@PathVariable Long id) {
        // Best Practice: Check existence before deletion
        if (!personRepository.existsById(id)) {
            return "Person not found with id:" + id;
        }
        personRepository.deleteById(id);
        return "Deleted Successfully";
    }

    @PutMapping("/updatePerson/{id}")
    public String updatePerson(@RequestBody Person person, Long id) {
        // Best Practice: Check existence before deletion
        Optional<Person> personExist = personRepository.findById(id);
        if (personExist.isEmpty() ) {
            return "Person not found with id:" + id;
        }
        personRepository.save(person);
        return "Deleted Successfully";
    }

}
