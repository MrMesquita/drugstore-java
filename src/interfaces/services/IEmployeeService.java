package interfaces.services;

import entities.Client;
import entities.Drugstore;
import entities.Employee;

public interface IEmployeeService {
    public void addEmployee(String name, int document, int telephone, int employeeCode, Drugstore drugstore);
    public void printAll();
    public void change(int oldEmployeeCode, Employee newEmployee);
    public void deleteEmployee(int employeeCode);
    public Employee findEmployee(int employeeCode);
    public void startSale(Client client, int cashierNumber);
}
