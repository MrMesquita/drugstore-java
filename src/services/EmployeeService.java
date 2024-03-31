package services;

import entities.*;
import exceptions.*;
import interfaces.services.IEmployeeClientService;
import interfaces.services.IEmployeeService;
import interfaces.repositories.IEmployeeRepository;
import repositories.EmployeeRepository;

import java.util.ArrayList;

public class EmployeeService implements IEmployeeService, IEmployeeClientService {
    private IEmployeeRepository repository = new EmployeeRepository();
    private ArrayList<Employee> employees = repository.getEmployees();
    @Override
    public void addEmployee(String name, int document, int telephone, int employeeCode, Drugstore drugstore) throws NameInvalidException, DocumentInvalidException, EmployeeCodeInvalidException {
        Employee employee = new Employee(name, document, telephone, employeeCode, drugstore);
        if (employee.getName() == null || employee.getName().trim().isEmpty() || employee.getName().length() < 3) {
            throw new NameInvalidException(employee.getName());
        }else if(employee.getDocument() < 8 || employee.getDocument() > 14){
            throw new DocumentInvalidException(employee.getDocument());
        }else if(employee.getEmployeeCode() != 0){
            throw new EmployeeCodeInvalidException(employee.getEmployeeCode());
        }else{
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
    public void change(int employeeCode, Employee newEmployee) throws EmployeeCodeInvalidException, NameInvalidException, DocumentInvalidException, EmployeeNotFoundException {
        if(employeeCode > 0){
            throw new EmployeeCodeInvalidException(employeeCode);
        }else if (newEmployee.getName() == null || newEmployee.getName().trim().isEmpty() || newEmployee.getName().length() < 3) {
            throw new NameInvalidException(newEmployee.getName());
        }else if(newEmployee.getDocument() < 8 || newEmployee.getDocument() > 14){
            throw new DocumentInvalidException(newEmployee.getDocument());
        }else{
            Employee foundedEmployee = findEmployee(employeeCode);
            if(foundedEmployee != null){
                repository.changeEmployee(employees.indexOf(foundedEmployee), newEmployee);
            }else{
                throw new EmployeeNotFoundException();
            }
        }

    }

    @Override
    public void deleteEmployee(int employeeCode) throws EmployeeNotFoundException, EmployeeCodeInvalidException {
        Employee foundedEmployee = findEmployee(employeeCode);
        if(foundedEmployee!= null){
            repository.removeEmployee(foundedEmployee);
        }else{
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public Employee findEmployee(int employeeCode) throws EmployeeCodeInvalidException {
        if(employeeCode < 0){
            throw new EmployeeCodeInvalidException(employeeCode);
        }
        for (Employee employee : employees){
            if(employee.getEmployeeCode() == employeeCode){
                return employee;
            }
        }
        return null;
    }

    @Override
    public void startSale(Client client, int cashierNumber) throws CashierException {
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
