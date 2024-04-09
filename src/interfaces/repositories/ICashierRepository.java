package interfaces.repositories;

import entities.Cashier;
import repositories.ListaCashier;

public interface ICashierRepository {
    public void saveCashier(Cashier cashier);
    public void changeCashier(int index, Cashier cashier);
    public ListaCashier getCashiers();
    public void removeCashiers(int index);
}
