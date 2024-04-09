package interfaces.repositories;

import entities.Drug;
import repositories.PilhaDrugs;

public interface IDrugRepository {
    public void saveDrug(Drug drug);
    public void changeDrug(int index, Drug newDrug);
    public PilhaDrugs getDrugs();
    public void removeDrug();
}
