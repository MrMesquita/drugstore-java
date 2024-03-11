package interfaces.repositories;

import entities.Person;

import java.util.ArrayList;

public interface IPersonRepository {
    public void savePerson(Person person);
    public void changePerson(int index, Person person);
    public ArrayList<Person> getPersons();
    public void removePerson(Person person);
}
