package interfaces.services;

import entities.Person;
import exceptions.DocumentInvalidException;
import exceptions.NameInvalidException;
import exceptions.NotFoundException;

public interface IPersonService {
    public void addPerson(String name, int document, int telephone) throws NameInvalidException, DocumentInvalidException;
    public void changePerson(String name, Person newPerson) throws DocumentInvalidException, NameInvalidException, NotFoundException;
    public void allPersons();
    public void deletePerson(String namePerson) throws NotFoundException;
    public Person findPerson(String namePerson) throws NotFoundException;
}
