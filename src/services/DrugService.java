package services;

import entities.Cashier;
import entities.Drug;
import entities.Product;
import exceptions.NameInvalidException;
import exceptions.ParamsProductInvalidException;
import exceptions.ProductInvalidException;
import exceptions.ProductNotFoundException;
import interfaces.repositories.IDrugRepository;
import interfaces.services.IDrugService;
import repositories.DrugRepository;
import repositories.PilhaDrugs;

import java.util.ArrayList;

public class DrugService implements IDrugService {
    private IDrugRepository repository = new DrugRepository();
    private PilhaDrugs drugs = repository.getDrugs();
    @Override
    public void addDrug(String name, float barcode, double price, boolean is_controlled) throws ProductInvalidException, ParamsProductInvalidException {
        if(name != null && barcode > 0 && price > 0 && is_controlled == false || is_controlled == true){
            Drug drug = new Drug(name, barcode, price, is_controlled);
            if(drug == null || drug.getName().isEmpty() || drug.getName().trim().isBlank() || drug.getBarcode() < 0 || drug.getPrice() < 0){
                throw new ProductInvalidException(drug);
            }else {
                repository.saveDrug(drug);
            }
        }else{
            throw new ParamsProductInvalidException(name,barcode,price);
        }
    }

    @Override
    public void changeDrug(String name, Drug newDrug) throws NameInvalidException, ProductInvalidException, ProductNotFoundException {
        Drug foundedDrug = findDrug(name);
        if(name == null || name.isEmpty() || name.trim().isBlank()){
            throw new NameInvalidException(name);
        }else if(newDrug == null || newDrug.getName().isEmpty() || newDrug.getName().trim().isBlank() || newDrug.getBarcode() < 0 || newDrug.getPrice() < 0){
            throw new ProductInvalidException(newDrug);
        }else if(foundedDrug == null || foundedDrug.getName().isEmpty() || foundedDrug.getName().trim().isBlank() || foundedDrug.getBarcode() < 0 || foundedDrug.getPrice() < 0){
            throw new ProductNotFoundException();
        }else{
            repository.changeDrug(drugs.indexOf(foundedDrug), newDrug);
        }
    }

    @Override
    public void deleteDrug() {
        repository.removeDrug();
    }

    @Override
    public void printDrugs() {
        for(Drug drug : drugs.getPilha()){
            System.out.println(
                "Nome: "+drug.getName()+
                "\nR$ "+drug.getPrice()
            );
        }
    }

    @Override
    public Drug findDrug(String name) throws NameInvalidException {
        if(name.isEmpty() || name.trim().isBlank()){
            throw new NameInvalidException(name);
        }
        for (Drug drug : drugs.getPilha()){
            if(drug.getName().equals(name)){
                return drug;
            }
        }
        return null;
    }
}
