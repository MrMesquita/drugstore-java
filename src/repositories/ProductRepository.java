package repositories;

import entities.Product;
import interfaces.repositories.IProductRepository;
import java.util.ArrayList;

public class ProductRepository implements IProductRepository {
    private ArrayList<Product> products = new ArrayList<>();

    @Override
    public void saveProduct(Product product) {
        products.add(product);
    }

    @Override
    public void changeProduct(int index, Product newProduct) {
        products.set(index, newProduct);
    }

    @Override
    public ArrayList<Product> getProducts() {
        return products;
    }

    @Override
    public void removeProduct(Product product) {
        products.remove(product);
    }
}
