package interfaces.services;

import entities.Cashier;
import entities.Client;
import entities.Employee;
import entities.Product;
import exceptions.*;

import java.util.ArrayList;

public interface ICashierService {
    public void addCashier(int number, Employee employee) throws CashierInvalidException, NameInvalidException, DocumentInvalidException, EmployeeCodeInvalidException;
    public void change(int number, Cashier newCashier) throws CashierException, NameInvalidException, DocumentInvalidException, EmployeeCodeInvalidException, CashierInvalidException;
    public void deleteCashier(int number) throws CashierException;
    public void printCashiers();
    public Cashier findCashier(int number) throws CashierException;
    public double passProducts(ArrayList<Product> productsOnCart) throws CashierException;
    public void finishSale(Client client);
}
