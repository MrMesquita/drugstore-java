package interfaces.services;

import entities.Drug;
import exceptions.NameInvalidException;
import exceptions.ParamsProductInvalidException;
import exceptions.ProductInvalidException;
import exceptions.ProductNotFoundException;

public interface IDrugService {
    public void addDrug(String name, float barcode, double price, boolean is_controlled) throws ProductInvalidException, ParamsProductInvalidException;
    public void changeDrug(String name, Drug newDrug) throws NameInvalidException, ProductInvalidException, ProductNotFoundException;
    public void deleteDrug(String name) throws NameInvalidException;
    public void printDrugs();
    public Drug findDrug(String name) throws NameInvalidException;
}
