package repositories;

import entities.Sale;
import interfaces.repositories.ISaleRepository;
import java.util.ArrayList;

public class SaleRepository implements ISaleRepository {
    private ArrayList<Sale> sales = new ArrayList<>();

    @Override
    public void saveSale(Sale sale) {
        sales.add(sale);
    }

    @Override
    public void change(int index, Sale newSale) {
        sales.set(index, newSale);
    }

    @Override
    public ArrayList<Sale> getSales() {
        return sales;
    }

    @Override
    public void removeSale(Sale sale) {
        sales.remove(sale);
    }
}
