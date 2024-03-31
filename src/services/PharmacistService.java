package services;

import entities.Drugstore;
import entities.Pharmacist;
import exceptions.*;
import interfaces.repositories.IPharmacistRepository;
import interfaces.services.IPharmacistService;
import repositories.PharmacistRepository;

import java.util.ArrayList;

public class PharmacistService implements IPharmacistService {
    private IPharmacistRepository repository = new PharmacistRepository();
    private ArrayList<Pharmacist> pharmacists = repository.getPharmacists();

    @Override
    public void addPharmacist(String name, int document, int telephone, int employeeCode, Drugstore drugstore, int CRF) throws NameInvalidException, DocumentInvalidException, EmployeeCodeInvalidException {
        Pharmacist pharmacist = new Pharmacist(name, document, telephone, employeeCode, drugstore, CRF);
        if (pharmacist.getName() == null || pharmacist.getName().trim().isEmpty() || pharmacist.getName().length() < 3) {
            throw new NameInvalidException(name);
        }else if(pharmacist.getDocument() < 8 || pharmacist.getDocument() > 14){
            throw new DocumentInvalidException(pharmacist.getDocument());
        }else if(pharmacist.getEmployeeCode() != 0){
            throw new EmployeeCodeInvalidException(pharmacist.getEmployeeCode());
        }else{
            repository.savePharmacist(pharmacist);
        }
    }

    @Override
    public void changePharmacist(int employeeCode, Pharmacist newPharmacist) throws NameInvalidException, DocumentInvalidException, NotFoundException, CRFInvalidException, EmployeeCodeInvalidException {
        if(employeeCode > 0){
            throw new EmployeeCodeInvalidException(employeeCode);
        }else if (newPharmacist.getName() == null || newPharmacist.getName().trim().isEmpty() || newPharmacist.getName().length() < 3) {
            throw new NameInvalidException(newPharmacist.getName());
        }else if(newPharmacist.getDocument() < 8 || newPharmacist.getDocument() > 14){
            throw new DocumentInvalidException(newPharmacist.getDocument());
        }else if(newPharmacist.getCRF() != 0){
            throw new CRFInvalidException(newPharmacist.getCRF());
        }else{
            Pharmacist foundedPharmacist = findPharmacist(employeeCode);
            repository.changePharmacist(pharmacists.indexOf(foundedPharmacist), newPharmacist);
        }
    }

    @Override
    public void allPharmacists() {
        for (Pharmacist pharmacist : pharmacists) {
            System.out.println(
                "Nome: " + pharmacist.getName() +
                "\nDocumento: " + pharmacist.getDocument() +
                "\nTelefone: " + pharmacist.getTelephone() +
                "\nCódigo do Funcionário: " + pharmacist.getEmployeeCode()
            );
        }
    }

    @Override
    public void deletePharmacist(int employeeCode) throws NotFoundException {
        Pharmacist foundedPharmacist = findPharmacist(employeeCode);
        if (foundedPharmacist != null) {
            repository.removePharmacist(foundedPharmacist);
        }
    }

    @Override
    public Pharmacist findPharmacist(int employeeCode) throws NotFoundException {
        for (Pharmacist pharmacist : pharmacists) {
            if (pharmacist.getEmployeeCode() == employeeCode) {
                return pharmacist;
            }else{
                throw new NotFoundException("Farmacêutico");
            }
        }
        return null;
    }
}
