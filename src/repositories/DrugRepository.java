package repositories;

import entities.Drug;
import interfaces.repositories.IDrugRepository;

public class DrugRepository implements IDrugRepository {
    private PilhaDrugs drugs = new PilhaDrugs();

    @Override
    public void saveDrug(Drug drug) {
        drugs.push(drug);
    }

    @Override
    public void changeDrug(int index, Drug newDrug) {
        drugs.set(index, newDrug);
    }

    @Override
    public PilhaDrugs getDrugs() {
        return drugs;
    }

    @Override
    public void removeDrug() {
        drugs.pop();
    }
}
