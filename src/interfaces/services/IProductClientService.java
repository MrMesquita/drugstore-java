package interfaces.services;

import entities.Product;

public interface IProductClientService {
    public void allProducts();

    public Product findProduct(String nameProduct);
}
