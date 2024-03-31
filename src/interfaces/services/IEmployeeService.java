package interfaces.services;

import entities.Client;
import entities.Drugstore;
import entities.Employee;
import exceptions.*;

public interface IEmployeeService {
    public void addEmployee(String name, int document, int telephone, int employeeCode, Drugstore drugstore) throws NameInvalidException, DocumentInvalidException, EmployeeCodeInvalidException;
    public void printAll();
    public void change(int oldEmployeeCode, Employee newEmployee) throws EmployeeCodeInvalidException, NameInvalidException, DocumentInvalidException, EmployeeNotFoundException;
    public void deleteEmployee(int employeeCode) throws EmployeeNotFoundException, EmployeeCodeInvalidException;
    public Employee findEmployee(int employeeCode) throws EmployeeCodeInvalidException;
    public void startSale(Client client, int cashierNumber) throws CashierException;
}
