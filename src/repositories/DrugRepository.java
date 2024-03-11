package repositories;

import entities.Drug;
import interfaces.repositories.IDrugRepository;
import java.util.ArrayList;

public class DrugRepository implements IDrugRepository {
    private ArrayList<Drug> drugs = new ArrayList<>();

    @Override
    public void saveDrug(Drug drug) {
        drugs.add(drug);
    }

    @Override
    public void changeDrug(int index, Drug newDrug) {
        drugs.set(index, newDrug);
    }

    @Override
    public ArrayList<Drug> getDrugs() {
        return drugs;
    }

    @Override
    public void removeDrug(Drug drug) {
        drugs.remove(drug);
    }
}
