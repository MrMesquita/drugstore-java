package interfaces.services;

import entities.Product;

public interface IProductService {
    public void addProduct(String name, float barcode, double price);
    public void changeProduct(String name, Product newProduct);
    public void allProducts();
    public void deleteProduct(String nameProduct);
    public Product findProduct(String nameProduct);
}
