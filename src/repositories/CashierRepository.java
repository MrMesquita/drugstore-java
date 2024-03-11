package repositories;

import entities.Cashier;
import interfaces.repositories.ICashierRepository;
import java.util.ArrayList;

public class CashierRepository implements ICashierRepository {
    private ArrayList<Cashier> cashiers = new ArrayList<>();

    @Override
    public void saveCashier(Cashier cashier) {
        cashiers.add(cashier);
    }

    @Override
    public void changeCashier(int index, Cashier newCashier) {
        cashiers.set(index, newCashier);
    }

    @Override
    public ArrayList<Cashier> getCashiers() {
        return cashiers;
    }

    @Override
    public void removeCashiers(Cashier cashier) {
        cashiers.remove(cashier);
    }
}
