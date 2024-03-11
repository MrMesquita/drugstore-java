package interfaces.services;

import entities.Cashier;
import entities.Client;
import entities.Employee;
import entities.Product;

import java.util.ArrayList;

public interface ICashierService {
    public void addCashier(int number, Employee employee);
    public void change(int number, Employee newEmployee);
    public void deleteCashier(int number);
    public void printCashiers();
    public Cashier findCashier(int number);
    public double passProducts(ArrayList<Product> productsOnCart);
    public void finishSale(Client client);
}
