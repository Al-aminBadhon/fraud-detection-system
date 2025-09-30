package com.dev.FraudDetection.repository;

import com.dev.FraudDetection.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
