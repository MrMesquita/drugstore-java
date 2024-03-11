package services;

import entities.Cashier;
import entities.Client;
import entities.Employee;
import entities.Product;
import interfaces.services.ICashierService;
import interfaces.repositories.ICashierRepository;
import repositories.CashierRepository;

import java.util.ArrayList;

public class CashierService implements ICashierService {
    private ICashierRepository repository = new CashierRepository();
    private ArrayList<Cashier> cashiers = repository.getCashiers();
    @Override
    public void addCashier(int number, Employee employee) {
        Cashier cashier = new Cashier(number, employee);
        if(cashier != null){
            repository.saveCashier(cashier);
        }
    }

    @Override
    public void change(int number, Employee newEmployee) {
        Cashier foundedCashier = findCashier(number);
        if(foundedCashier != null){
            foundedCashier.setEmployee(newEmployee);
        }
    }

    @Override
    public void deleteCashier(int number) {
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
    public Cashier findCashier(int number) {
        for (Cashier cashier : cashiers){
            if(cashier.getNumber() == number){
                return cashier;
            }
        }
        return null;
    }

    @Override
    public double passProducts(ArrayList<Product> productsOnCart) {
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
