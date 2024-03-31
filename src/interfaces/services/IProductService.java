package interfaces.services;

import entities.Product;
import exceptions.NameInvalidException;
import exceptions.ParamsProductInvalidException;
import exceptions.ProductInvalidException;
import exceptions.ProductNotFoundException;

public interface IProductService {
    public void addProduct(String name, float barcode, double price) throws ProductInvalidException, ParamsProductInvalidException;
    public void changeProduct(String name, Product newProduct) throws NameInvalidException, ProductInvalidException, ProductNotFoundException;
    public void allProducts();
    public void deleteProduct(String nameProduct) throws NameInvalidException;
    public Product findProduct(String nameProduct) throws NameInvalidException;
}
