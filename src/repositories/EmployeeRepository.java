package repositories;

import entities.Employee;
import interfaces.repositories.IEmployeeRepository;
import java.util.ArrayList;

public class EmployeeRepository implements IEmployeeRepository {
    private ArrayList<Employee> employees = new ArrayList<>();

    @Override
    public void saveEmployee(Employee employee) {
        employees.add(employee);
    }

    @Override
    public void changeEmployee(int index, Employee newEmployee) {
        employees.set(index, newEmployee);
    }

    @Override
    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    @Override
    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }
}
