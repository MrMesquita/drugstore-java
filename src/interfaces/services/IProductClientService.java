package interfaces.services;

import entities.Product;
import exceptions.NameInvalidException;

public interface IProductClientService {
    public void allProducts();

    public Product findProduct(String nameProduct) throws NameInvalidException;
}
