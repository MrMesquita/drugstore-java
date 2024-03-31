package services;

import entities.Drugstore;
import exceptions.AdressInvalidException;
import exceptions.DrugstoreNotFoundException;
import exceptions.NameInvalidException;
import interfaces.repositories.IDrugstoreRepository;
import interfaces.services.IDrugstoreService;
import repositories.DrugstoreRepository;

import java.util.ArrayList;

public class DrugstoreService implements IDrugstoreService {
    private IDrugstoreRepository repository = new DrugstoreRepository();
    private ArrayList<Drugstore> drugstores = repository.getDrugstores();

    @Override
    public void addDrugstore(String name, String address) throws NameInvalidException, AdressInvalidException {
        if(name == null || name.isEmpty() || name.trim().isBlank()){
            throw new NameInvalidException(name);
        }else if(address == null || address.isEmpty() || address.trim().isBlank()){
            throw new AdressInvalidException();
        }
        Drugstore drugstore = new Drugstore(name, address);
        if (drugstore != null) {
            repository.saveDrugstore(drugstore);
        }
    }

    @Override
    public void changeDrugstore(String name, Drugstore newDrugstore) throws NameInvalidException, AdressInvalidException, DrugstoreNotFoundException {
        if(name == null || name.isEmpty() || name.trim().isBlank()){
            throw new NameInvalidException(name);
        }else if(newDrugstore.getName() == null || newDrugstore.getName().isEmpty() || newDrugstore.getName().trim().isBlank()){
            throw new NameInvalidException(newDrugstore.getName());
        }else if(newDrugstore.getAddress() == null || newDrugstore.getAddress().isEmpty() || newDrugstore.getAddress().trim().isBlank()){
            throw new AdressInvalidException();
        }
        Drugstore foundedDrugstore = findDrugstore(name);
        if (foundedDrugstore == null) {
            throw new DrugstoreNotFoundException();
        }else{
            repository.changeDrugstore(drugstores.indexOf(foundedDrugstore), newDrugstore);
        }
    }

    @Override
    public void deleteDrugstore(String name) throws NameInvalidException, DrugstoreNotFoundException {
        if(name == null || name.isEmpty() || name.trim().isBlank()){
            throw new NameInvalidException(name);
        }
        Drugstore foundedDrugstore = findDrugstore(name);
        if (foundedDrugstore == null) {
            throw new DrugstoreNotFoundException();
        }else {
            repository.removeDrugstore(foundedDrugstore);
        }
    }

    @Override
    public void printDrugstores() {
        for (Drugstore drugstore : drugstores) {
            System.out.println(
                "Nome: " + drugstore.getName() +
                "\nEndereço: " + drugstore.getAddress()
            );
        }
    }

    @Override
    public Drugstore findDrugstore(String name) throws NameInvalidException {
        if(name == null || name.isEmpty() || name.trim().isBlank()){
            throw new NameInvalidException(name);
        }
        for (Drugstore drugstore : drugstores) {
            if (drugstore.getName().equals(name)) {
                return drugstore;
            }
        }
        return null;
    }
}
