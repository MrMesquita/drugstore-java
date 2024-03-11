package interfaces.repositories;

import entities.Drug;
import entities.Drugstore;

import java.util.ArrayList;

public interface IDrugstoreRepository {
    public void saveDrugstore(Drugstore drugstore);
    public void changeDrugstore(int index, Drugstore newDrugstore);
    public ArrayList<Drugstore> getDrugstores();
    public void removeDrugstore(Drugstore drugstore);
}
