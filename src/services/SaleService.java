package services;

import entities.Client;
import entities.Employee;
import entities.Product;
import entities.Sale;
import interfaces.repositories.IProductRepository;
import interfaces.repositories.ISaleRepository;
import interfaces.services.ISaleService;
import repositories.ProductRepository;
import repositories.SaleRepository;

import java.util.ArrayList;

public class SaleService implements ISaleService {
    private ISaleRepository repository = new SaleRepository();
    private ArrayList<Sale> sales = repository.getSales();

    @Override
    public void saveSale(Employee employee, Client client, String typeOfPayament) {
        Sale sale = new Sale(employee, client, typeOfPayament);
        if(sale != null){
            repository.saveSale(sale);
        }
    }

    @Override
    public void printSales() {
        for(Sale sale : sales){
            System.out.println(sale.getClient() +"\n"+ sale.getTotal()+"\n"+sale.getProducts());
        }
    }

    @Override
    public void removeSale(Sale sale) {
        repository.removeSale(sale);
    }
}
