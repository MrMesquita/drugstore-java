package interfaces.services;

import entities.Client;
import entities.Employee;
import entities.Sale;
import exceptions.SaleInvalidException;
import exceptions.SaleNotFoundException;

import java.util.ArrayList;

public interface ISaleService {
    public void saveSale(Employee employee, Client client, String typeOfPayament) throws SaleInvalidException;
    public void printSales();
    public void removeSale(Sale sale) throws SaleNotFoundException;
}
