package services;

import entities.Cashier;
import entities.Client;
import entities.Employee;
import entities.Product;
import exceptions.*;
import interfaces.services.ICashierService;
import interfaces.repositories.ICashierRepository;
import repositories.CashierRepository;

import java.util.ArrayList;

public class CashierService implements ICashierService {
    private ICashierRepository repository = new CashierRepository();
    private ArrayList<Cashier> cashiers = repository.getCashiers();
    @Override
    public void addCashier(int number, Employee employee) throws CashierInvalidException, NameInvalidException, DocumentInvalidException, EmployeeCodeInvalidException {
        if(number < 0 || employee == null){
            throw new CashierInvalidException();
        }else if (employee.getName() == null || employee.getName().trim().isEmpty() || employee.getName().length() < 3) {
            throw new NameInvalidException(employee.getName());
        }else if(employee.getDocument() < 8 || employee.getDocument() > 14){
            throw new DocumentInvalidException(employee.getDocument());
        }else if(employee.getEmployeeCode() != 0){
            throw new EmployeeCodeInvalidException(employee.getEmployeeCode());
        }
        Cashier cashier = new Cashier(number, employee);
        if(cashier != null){
            repository.saveCashier(cashier);
        }
    }

    @Override
    public void change(int number, Cashier newCashier) throws CashierException, NameInvalidException, DocumentInvalidException, EmployeeCodeInvalidException, CashierInvalidException {
        if(number < 0 || newCashier.getEmployee() == null){
            throw new CashierInvalidException();
        }else if (newCashier.getEmployee().getName() == null || newCashier.getEmployee().getName().trim().isEmpty() || newCashier.getEmployee().getName().length() < 3) {
            throw new NameInvalidException(newCashier.getEmployee().getName());
        }else if(newCashier.getEmployee().getDocument() < 8 || newCashier.getEmployee().getDocument() > 14){
            throw new DocumentInvalidException(newCashier.getEmployee().getDocument());
        }else if(newCashier.getEmployee().getEmployeeCode() != 0){
            throw new EmployeeCodeInvalidException(newCashier.getEmployee().getEmployeeCode());
        }
        Cashier foundedCashier = findCashier(number);
        if(foundedCashier != null){
            repository.changeCashier(cashiers.indexOf(foundedCashier), newCashier);
        }
    }

    @Override
    public void deleteCashier(int number) throws CashierException {
        if(number < 0){
            throw new CashierException("Número inválido!");
        }

        Cashier foundedCashier = findCashier(number);
        if(foundedCashier != null){
            repository.removeCashiers(foundedCashier);
        }
    }

    @Override
    public void printCashiers() {
        for(Cashier cashier : cashiers){
            System.out.println(
                "Caixa "+cashier.getNumber()+
                "\nFuncionário: "+cashier.getEmployee().getName()
            );
        }
    }

    @Override
    public Cashier findCashier(int number) throws CashierException {
        if(number < 0){
            throw new CashierException("Número inválido!");
        }

        for (Cashier cashier : cashiers){
            if(cashier.getNumber() == number){
                return cashier;
            }
        }
        return null;
    }

    @Override
    public double passProducts(ArrayList<Product> productsOnCart) throws CashierException {
        if(productsOnCart.isEmpty()){
            throw new CashierException("Você não adicionou itens a cesta");
        }

        double total = 0;
        for(Product product : productsOnCart){
            total += product.getPrice();
        }
        return total;
    }

    @Override
    public void finishSale(Client client) {
        while (!client.getCart().isEmpty()){
            client.getCart().removeFirst();
        }
    }


}
