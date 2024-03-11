package repositories;

import entities.Pharmacist;
import interfaces.repositories.IPharmacistRepository;
import java.util.ArrayList;

public class PharmacistRepository implements IPharmacistRepository {
    private ArrayList<Pharmacist> pharmacists = new ArrayList<>();

    @Override
    public void savePharmacist(Pharmacist pharmacist) {
        pharmacists.add(pharmacist);
    }

    @Override
    public void changePharmacist(int index, Pharmacist newPharmacist) {
        pharmacists.set(index, newPharmacist);
    }

    @Override
    public ArrayList<Pharmacist> getPharmacists() {
        return pharmacists;
    }

    @Override
    public void removePharmacist(Pharmacist pharmacist) {
        pharmacists.remove(pharmacist);
    }
}
