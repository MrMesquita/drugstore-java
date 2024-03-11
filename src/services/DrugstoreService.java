package services;

import entities.Drugstore;
import interfaces.repositories.IDrugstoreRepository;
import interfaces.services.IDrugstoreService;
import repositories.DrugstoreRepository;

import java.util.ArrayList;

public class DrugstoreService implements IDrugstoreService {
    private IDrugstoreRepository repository = new DrugstoreRepository();
    private ArrayList<Drugstore> drugstores = repository.getDrugstores();

    @Override
    public void addDrugstore(String name, String address) {
        Drugstore drugstore = new Drugstore(name, address);
        if (drugstore != null) {
            repository.saveDrugstore(drugstore);
        }
    }

    @Override
    public void changeDrugstore(String name, Drugstore newDrugstore) {
        Drugstore foundedDrugstore = findDrugstore(name);
        if (foundedDrugstore != null) {
            repository.changeDrugstore(drugstores.indexOf(foundedDrugstore), newDrugstore);
        }
    }

    @Override
    public void deleteDrugstore(String name) {
        Drugstore foundedDrugstore = findDrugstore(name);
        if (foundedDrugstore != null) {
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
    public Drugstore findDrugstore(String name) {
        for (Drugstore drugstore : drugstores) {
            if (drugstore.getName().equals(name)) {
                return drugstore;
            }
        }
        return null;
    }
}
