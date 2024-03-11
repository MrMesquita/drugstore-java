package services;

import entities.Drugstore;
import entities.Pharmacist;
import interfaces.repositories.IPharmacistRepository;
import interfaces.services.IPharmacistService;
import repositories.PharmacistRepository;

import java.util.ArrayList;

public class PharmacistService implements IPharmacistService {
    private IPharmacistRepository repository = new PharmacistRepository();
    private ArrayList<Pharmacist> pharmacists = repository.getPharmacists();

    @Override
    public void addPharmacist(String name, int document, int telephone, int employeeCode, Drugstore drugstore, int CRF) {
        Pharmacist pharmacist = new Pharmacist(name, document, telephone, employeeCode, drugstore, CRF);
        if (pharmacist != null) {
            repository.savePharmacist(pharmacist);
        }
    }

    @Override
    public void changePharmacist(String name, Pharmacist newPharmacist) {
        Pharmacist foundedPharmacist = findPharmacist(name);
        if (foundedPharmacist != null) {
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
    public void deletePharmacist(String namePharmacist) {
        Pharmacist foundedPharmacist = findPharmacist(namePharmacist);
        if (foundedPharmacist != null) {
            repository.removePharmacist(foundedPharmacist);
        }
    }

    @Override
    public Pharmacist findPharmacist(String namePharmacist) {
        for (Pharmacist pharmacist : pharmacists) {
            if (pharmacist.getName().equals(namePharmacist)) {
                return pharmacist;
            }
        }
        return null;
    }
}
