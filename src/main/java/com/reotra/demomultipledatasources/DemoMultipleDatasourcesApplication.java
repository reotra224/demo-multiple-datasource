package com.reotra.demomultipledatasources;

import com.reotra.demomultipledatasources.readingdb.repository.PotentialStudentRepository;
import com.reotra.demomultipledatasources.writingdb.domain.Student;
import com.reotra.demomultipledatasources.writingdb.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
@Slf4j
public class DemoMultipleDatasourcesApplication implements CommandLineRunner {

    private final PotentialStudentRepository potentialStudentRepository;
    private final StudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoMultipleDatasourcesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        // Clear all data in both databases
        studentRepository.deleteAll();

        log.info("=============== Retrieve potential students in reading database");
        potentialStudentRepository.findAll().forEach(potentialStudent -> log.info("Potential Student: {}", potentialStudent));

        potentialStudentRepository.findAll().forEach(potentialStudent -> {
            log.info("Create New Student in writing database from PotentialStudent");
            studentRepository.save(new Student(null, potentialStudent.getName(), potentialStudent.getAge()));
        });

        log.info("=============== Retrieve students in writing database");
        studentRepository.findAll().forEach(student -> log.info("New Student: {}", student));
    }
}
