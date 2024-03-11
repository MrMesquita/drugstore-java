package entities;

import java.util.ArrayList;

public class Sale{
    private int id;
    private double total;
    private String typeOfPayament;
    private Employee employee;
    private Client client;
    private ArrayList<Product> products;

    public Sale(Employee employee, Client client, String typeOfPayament) {
        this.typeOfPayament = typeOfPayament;
        this.employee = employee;
        products = new ArrayList<>();
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getTypeOfPayament() {
        return typeOfPayament;
    }

    public void setTypeOfPayament(String typeOfPayament) {
        this.typeOfPayament = typeOfPayament;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
}
