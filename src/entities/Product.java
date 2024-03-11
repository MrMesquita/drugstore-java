package entities;

public class Product {
    private String name;
    private float barcode;
    private double price;

    public Product(String name, float barcode, double price) {
        this.name = name;
        this.barcode = barcode;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getBarcode() {
        return barcode;
    }

    public void setBarcode(float barcode) {
        this.barcode = barcode;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
