package services;

import entities.Person;
import interfaces.repositories.IPersonRepository;
import interfaces.services.IPersonService;
import repositories.PersonRepository;

import java.util.ArrayList;

public class PersonService implements IPersonService {
    private IPersonRepository repository = new PersonRepository();
    private ArrayList<Person> persons = repository.getPersons();

    @Override
    public void addPerson(String name, int document, int telephone) {
        Person person = new Person(name, document, telephone);
        if (person != null) {
            repository.savePerson(person);
        }
    }

    @Override
    public void changePerson(String name, Person newPerson) {
        Person foundedPerson = findPerson(name);
        if (foundedPerson != null) {
            repository.changePerson(persons.indexOf(foundedPerson), newPerson);
        }
    }

    @Override
    public void allPersons() {
        for (Person person : persons) {
            System.out.println(person.getName());
        }
    }

    @Override
    public void deletePerson(String namePerson) {
        Person foundedPerson = findPerson(namePerson);
        if (foundedPerson != null) {
            repository.removePerson(foundedPerson);
        }
    }

    @Override
    public Person findPerson(String namePerson) {
        for (Person person : persons) {
            if (person.getName().equals(namePerson)) {
                return person;
            }
        }
        return null;
    }
}
