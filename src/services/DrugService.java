package services;

import entities.Cashier;
import entities.Drug;
import interfaces.repositories.IDrugRepository;
import interfaces.services.IDrugService;
import repositories.DrugRepository;

import java.util.ArrayList;

public class DrugService implements IDrugService {
    private IDrugRepository repository = new DrugRepository();
    private ArrayList<Drug> drugs = repository.getDrugs();
    @Override
    public void addDrug(String name, float barcode, double price, boolean is_controlled) {
        Drug drug = new Drug(name, barcode, price, is_controlled);
        if(drug != null){
            repository.saveDrug(drug);
        }
    }

    @Override
    public void changeDrug(String name, Drug newDrug) {
        Drug foundedDrug = findDrug(name);
        if(foundedDrug != null){
            repository.changeDrug(drugs.indexOf(foundedDrug), newDrug);
        }
    }

    @Override
    public void deleteDrug(String name) {
        Drug foundedDrug = findDrug(name);
        if(foundedDrug != null){
            repository.removeDrug(foundedDrug);
        }
    }

    @Override
    public void printDrugs() {
        for(Drug drug : drugs){
            System.out.println(
                "Nome: "+drug.getName()+
                "\nR$ "+drug.getPrice()
            );
        }
    }

    @Override
    public Drug findDrug(String name) {
        for (Drug drug : drugs){
            if(drug.getName() == name){
                return drug;
            }
        }
        return null;
    }
}
