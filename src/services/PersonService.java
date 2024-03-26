package services;

import entities.Person;
import exceptions.DocumentInvalidException;
import exceptions.NameInvalidException;
import exceptions.NotFoundException;
import interfaces.repositories.IPersonRepository;
import interfaces.services.IPersonService;
import repositories.PersonRepository;

import java.util.ArrayList;

public class PersonService implements IPersonService {
    private IPersonRepository repository = new PersonRepository();
    private ArrayList<Person> persons = repository.getPersons();

    @Override
    public void addPerson(String name, int document, int telephone) throws NameInvalidException, DocumentInvalidException {
        Person person = new Person(name, document, telephone);
        if (person.getName() == null || person.getName().trim().isEmpty() || person.getName().length() < 3) {
            throw new NameInvalidException(name);
        }else if(person.getDocument() < 8 || person.getDocument() > 14){
            throw new DocumentInvalidException(person.getDocument());
        } else{
            repository.savePerson(person);
        }
    }

    @Override
    public void changePerson(String name, Person newPerson) throws NameInvalidException, DocumentInvalidException, NotFoundException {
        if(name == null || name.trim().isEmpty() || name.trim().isBlank()){
            throw new NameInvalidException(name);
        }else if (newPerson.getName() == null || newPerson.getName().trim().isEmpty() || newPerson.getName().length() < 3) {
            throw new NameInvalidException(newPerson.getName());
        }else if(newPerson.getDocument() < 8 || newPerson.getDocument() > 14){
            throw new DocumentInvalidException(newPerson.getDocument());
        }else{
            Person foundedPerson = findPerson(name);
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
    public void deletePerson(String namePerson) throws NotFoundException {
        Person foundedPerson = findPerson(namePerson);
        if (foundedPerson != null) {
            repository.removePerson(foundedPerson);
        }
    }

    @Override
    public Person findPerson(String namePerson) throws NotFoundException {
        for (Person person : persons) {
            if (person.getName().equals(namePerson)) {
                return person;
            }else{
                throw new NotFoundException("pessoa");
            }
        }
        return null;
    }
}
