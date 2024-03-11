package interfaces.services;

import entities.Client;
import entities.Employee;
import entities.Sale;

import java.util.ArrayList;

public interface ISaleService {
    public void saveSale(Employee employee, Client client, String typeOfPayament);
    public void printSales();
    public void removeSale(Sale sale);
}
