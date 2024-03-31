package interfaces.services;

import entities.Drugstore;
import exceptions.AdressInvalidException;
import exceptions.DrugstoreNotFoundException;
import exceptions.NameInvalidException;

public interface IDrugstoreService {
    public void addDrugstore(String name, String address) throws NameInvalidException, AdressInvalidException;
    public void changeDrugstore(String name, Drugstore newDrugstore) throws NameInvalidException, AdressInvalidException, DrugstoreNotFoundException;
    public void deleteDrugstore(String name) throws NameInvalidException, DrugstoreNotFoundException;
    public void printDrugstores();
    public Drugstore findDrugstore(String name) throws NameInvalidException;
}
