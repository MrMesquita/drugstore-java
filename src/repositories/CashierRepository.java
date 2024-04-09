package repositories;

import entities.Cashier;
import interfaces.repositories.ICashierRepository;

public class CashierRepository implements ICashierRepository {
    private ListaCashier cashiers = new ListaCashier();

    @Override
    public void saveCashier(Cashier cashier) {
        cashiers.addFirst(cashier);
    }

    @Override
    public void changeCashier(int index, Cashier newCashier) {
        cashiers.set(index, newCashier);
    }

    @Override
    public ListaCashier getCashiers() {
        return cashiers;
    }

    @Override
    public void removeCashiers(int index) {
        cashiers.delete(index);
    }
}
