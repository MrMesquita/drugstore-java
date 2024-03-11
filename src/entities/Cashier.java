package entities;

public class Cashier {
    private int number;
    private Employee employee;

    public Cashier(int number, Employee employee) {
        this.number = number;
        this.employee = employee;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
