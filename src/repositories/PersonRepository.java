package repositories;

import entities.Person;
import interfaces.repositories.IPersonRepository;
import java.util.ArrayList;

public class PersonRepository implements IPersonRepository {
    private ArrayList<Person> persons = new ArrayList<>();

    @Override
    public void savePerson(Person person) {
        persons.add(person);
    }

    @Override
    public void changePerson(int index, Person newPerson) {
        persons.set(index, newPerson);
    }

    @Override
    public ArrayList<Person> getPersons() {
        return persons;
    }

    @Override
    public void removePerson(Person person) {
        persons.remove(person);
    }
}
