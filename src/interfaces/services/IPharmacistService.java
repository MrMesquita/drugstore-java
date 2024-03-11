package interfaces.services;

import entities.Drugstore;
import entities.Pharmacist;

public interface IPharmacistService {
    public void addPharmacist(String name, int document, int telephone, int employeeCode, Drugstore drugstore, int CRF);
    public void changePharmacist(String name, Pharmacist newPharmacist);
    public void allPharmacists();
    public void deletePharmacist(String namePharmacist);
    public Pharmacist findPharmacist(String namePharmacist);
}
