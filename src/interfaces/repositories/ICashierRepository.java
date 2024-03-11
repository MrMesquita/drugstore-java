package interfaces.repositories;

import entities.Cashier;

import java.util.ArrayList;

public interface ICashierRepository {
    public void saveCashier(Cashier cashier);
    public void changeCashier(int index, Cashier cashier);
    public ArrayList<Cashier> getCashiers();
    public void removeCashiers(Cashier cashier);
}
