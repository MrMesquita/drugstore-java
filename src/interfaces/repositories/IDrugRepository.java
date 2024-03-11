package interfaces.repositories;

import entities.Drug;

import java.util.ArrayList;

public interface IDrugRepository {
    public void saveDrug(Drug drug);
    public void changeDrug(int index, Drug newDrug);
    public ArrayList<Drug> getDrugs();
    public void removeDrug(Drug drug);
}
