package interfaces.repositories;

import entities.Product;

import java.util.ArrayList;

public interface IProductRepository {
    public void saveProduct(Product product);
    public void changeProduct(int index, Product product);
    public ArrayList<Product> getProducts();
    public void removeProduct(Product product);
}
