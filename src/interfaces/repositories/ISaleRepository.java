package interfaces.repositories;

import entities.Sale;

import java.util.ArrayList;

public interface ISaleRepository {
    public void saveSale(Sale sale);
    public void change(int index, Sale sale);
    public ArrayList<Sale> getSales();
    public void removeSale(Sale sale);
}
