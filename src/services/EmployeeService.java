package services;

import entities.*;
import interfaces.services.IEmployeeClientService;
import interfaces.services.IEmployeeService;
import interfaces.repositories.IEmployeeRepository;
import repositories.EmployeeRepository;

import java.util.ArrayList;

public class EmployeeService implements IEmployeeService, IEmployeeClientService {
    private IEmployeeRepository repository = new EmployeeRepository();
    private ArrayList<Employee> employees = repository.getEmployees();
    @Override
    public void addEmployee(String name, int document, int telephone, int employeeCode, Drugstore drugstore) {
        Employee employee = new Employee(name, document, telephone, employeeCode, drugstore);
        if(employee != null){
            repository.saveEmployee(employee);
        }
    }

    @Override
    public void printAll() {
        for (Employee employee : employees){
            System.out.println(
                "Nome: "+employee.getName()+
                "\nDocumento: "+employee.getDocument()+
                "\nTelefone: "+employee.getTelephone()
            );
        }
    }

    @Override
    public void change(int employeeCode, Employee newEmployee) {
        Employee foundedEmployee = findEmployee(employeeCode);
        if(foundedEmployee != null){
            repository.changeEmployee(employees.indexOf(foundedEmployee), newEmployee);
        }
    }

    @Override
    public void deleteEmployee(int employeeCode) {
        Employee foundedEmployee = findEmployee(employeeCode);
        if(foundedEmployee!= null){
            repository.removeEmployee(foundedEmployee);
        }
    }

    @Override
    public Employee findEmployee(int employeeCode) {
        for (Employee employee : employees){
            if(employee.getEmployeeCode() == employeeCode){
                return employee;
            }
        }
        return null;
    }

    @Override
    public void startSale(Client client, int cashierNumber) {
        CashierService cashierService = new CashierService();
        Cashier cashier = cashierService.findCashier(cashierNumber);

        double total = cashierService.passProducts(client.getCart());
        System.out.println("O valor total da compra foi: "+total);
        /*

            Lógica para receber e validar pagamento

         */

        cashierService.finishSale(client);

    }


}
