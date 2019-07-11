package io.zipcoder.crudapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private PersonRepository repository;

    @Autowired
    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public Iterable<Person> index() {
        return repository.findAll();
    }

    public Person findOne(Long id){
        return repository.findOne(id);
    }

    public Person create(Person person) {
        return repository.save(person);
    }

    public Person update(Long id, Person personData) {
        Person person = repository.findOne(id);
        person.setFirstName(personData.getFirstName());
        person.setLastName(personData.getLastName());
        return repository.save(person);
    }

    public Boolean delete(Long id){
        repository.delete(id);
        return true;
    }

}
