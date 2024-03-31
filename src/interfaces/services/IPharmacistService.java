package interfaces.services;

import entities.Drugstore;
import entities.Pharmacist;
import exceptions.*;

public interface IPharmacistService {
    public void addPharmacist(String name, int document, int telephone, int employeeCode, Drugstore drugstore, int CRF) throws NameInvalidException, DocumentInvalidException, EmployeeCodeInvalidException;
    public void changePharmacist(int employeeCode, Pharmacist newPharmacist) throws NameInvalidException, DocumentInvalidException, NotFoundException, CRFInvalidException, EmployeeCodeInvalidException;
    public void allPharmacists();
    public void deletePharmacist(int employeeCode) throws NotFoundException;
    public Pharmacist findPharmacist(int employeeCode) throws NotFoundException;
}
