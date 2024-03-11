package interfaces.services;

import entities.Drugstore;

public interface IDrugstoreService {
    public void addDrugstore(String name, String address);
    public void changeDrugstore(String name, Drugstore newDrugstore);
    public void deleteDrugstore(String name);
    public void printDrugstores();
    public Drugstore findDrugstore(String name);
}
