package interfaces.services;

import entities.Drug;

public interface IDrugService {
    public void addDrug(String name, float barcode, double price, boolean is_controlled);
    public void changeDrug(String name, Drug newDrug);
    public void deleteDrug(String name);
    public void printDrugs();
    public Drug findDrug(String name);
}
