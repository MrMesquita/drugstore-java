package entities;

import java.util.ArrayList;

public class Sale<T extends Product>{
    private double total;
    private String payament;
    private Employee employee;
    private T product;

    public Sale(Employee employee, T product) {
        this.employee = employee;
        this.product = product;
    }


}
