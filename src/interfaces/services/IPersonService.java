package interfaces.services;

import entities.Person;

public interface IPersonService {
    public void addPerson(String name, int document, int telephone);
    public void changePerson(String name, Person newPerson);
    public void allPersons();
    public void deletePerson(String namePerson);
    public Person findPerson(String namePerson);
}
