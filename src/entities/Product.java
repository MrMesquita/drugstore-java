package entities;

public class Product {
    private String name;
    private float barcode;
    private int price;

    public Product(String name, float barcode, int price) {
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
