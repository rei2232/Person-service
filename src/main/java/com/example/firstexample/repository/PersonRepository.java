package com.example.firstexample.repository;

import com.example.firstexample.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PersonRepository extends MongoRepository<Person,String> {
    @Query("{name:'?0'}")
    Person findItemByName(String name);

    @Query("{id:'?0'}")
    public Person findItemById(String id);

    @Query(value="{category:'?0'}", fields="{'name' : 1, 'quantity' : 1}")
    List<Person> findAll(String category);

}
