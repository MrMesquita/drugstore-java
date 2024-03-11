package interfaces.repositories;

import entities.Employee;

import java.util.ArrayList;

public interface IEmployeeRepository {
    public void saveEmployee(Employee employee);
    public void changeEmployee(int index, Employee newEmployee);
    public ArrayList<Employee> getEmployees();
    public void removeEmployee(Employee employee);
}
