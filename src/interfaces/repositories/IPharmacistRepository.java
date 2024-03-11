package interfaces.repositories;

import entities.Pharmacist;

import java.util.ArrayList;

public interface IPharmacistRepository {
    public void savePharmacist(Pharmacist pharmacist);
    public void changePharmacist(int index, Pharmacist pharmacist);
    public ArrayList<Pharmacist> getPharmacists();
    public void removePharmacist(Pharmacist pharmacist);
}
