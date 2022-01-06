package com.example.firstexample;

import com.example.firstexample.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
public class FirstExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstExampleApplication.class, args);
    }



}
