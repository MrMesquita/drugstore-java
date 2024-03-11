package repositories;

import entities.Drugstore;
import interfaces.repositories.IDrugstoreRepository;
import java.util.ArrayList;

public class DrugstoreRepository implements IDrugstoreRepository {
    private ArrayList<Drugstore> drugstores = new ArrayList<>();

    @Override
    public void saveDrugstore(Drugstore drugstore) {
        drugstores.add(drugstore);
    }

    @Override
    public void changeDrugstore(int index, Drugstore newDrugstore) {
        drugstores.set(index, newDrugstore);
    }

    @Override
    public ArrayList<Drugstore> getDrugstores() {
        return drugstores;
    }

    @Override
    public void removeDrugstore(Drugstore drugstore) {
        drugstores.remove(drugstore);
    }
}
