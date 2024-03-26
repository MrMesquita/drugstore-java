package interfaces.services;

import entities.Drugstore;
import entities.Pharmacist;
import exceptions.*;

public interface IPharmacistService {
    public void addPharmacist(String name, int document, int telephone, int employeeCode, Drugstore drugstore, int CRF) throws NameInvalidException, DocumentInvalidException, EmployeeCodeInvalidException;
    public void changePharmacist(String name, Pharmacist newPharmacist) throws NameInvalidException, DocumentInvalidException, NotFoundException, CRFInvalidException;
    public void allPharmacists();
    public void deletePharmacist(String namePharmacist) throws NotFoundException;
    public Pharmacist findPharmacist(String namePharmacist) throws NotFoundException;
}
