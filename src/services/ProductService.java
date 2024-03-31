package services;

import entities.Drug;
import entities.Product;
import exceptions.NameInvalidException;
import exceptions.ParamsProductInvalidException;
import exceptions.ProductInvalidException;
import exceptions.ProductNotFoundException;
import interfaces.services.IProductClientService;
import interfaces.services.IProductService;
import interfaces.repositories.IProductRepository;
import repositories.ProductRepository;

import java.util.ArrayList;

public class ProductService implements IProductService, IProductClientService {
    private IProductRepository repository = new ProductRepository();
    private ArrayList<Product> products = repository.getProducts();
    @Override
    public void addProduct(String name, float barcode, double price) throws ProductInvalidException, ParamsProductInvalidException {
        if(name != null && barcode > 0 && price > 0){
            Product product = new Product(name, barcode, price);
            if(product == null || product.getName().isEmpty() || product.getName().trim().isBlank() || product.getBarcode() < 0 || product.getPrice() < 0){
                throw new ProductInvalidException(product);
            }else {
                repository.saveProduct(product);
            }
        }else{
            throw new ParamsProductInvalidException(name,barcode,price);
        }
    }

    @Override
    public void changeProduct(String name, Product newProduct) throws NameInvalidException, ProductInvalidException, ProductNotFoundException {
        Product foundedProduct = findProduct(name);
        if(name == null || name.isEmpty() || name.trim().isBlank()){
            throw new NameInvalidException(name);
        }else if(newProduct == null || newProduct.getName().isEmpty() || newProduct.getName().trim().isBlank() || newProduct.getBarcode() < 0 || newProduct.getPrice() < 0){
            throw new ProductInvalidException(newProduct);
        }else if(foundedProduct == null || foundedProduct.getName().isEmpty() || foundedProduct.getName().trim().isBlank() || foundedProduct.getBarcode() < 0 || foundedProduct.getPrice() < 0){
            throw new ProductNotFoundException();
        }else {
            repository.changeProduct(products.indexOf(foundedProduct), newProduct);
        }
    }

    @Override
    public void allProducts() {
        for(Product product : products){
           System.out.println(
               product.getName()+
               "\nR$ "+product.getPrice()+
               "\nCódigo de barras: "+product.getBarcode()
           );
        }
    }

    @Override
    public void deleteProduct(String nameProduct) throws NameInvalidException {
        if(nameProduct == null || nameProduct.isEmpty() || nameProduct.trim().isBlank()){
            throw new NameInvalidException(nameProduct);
        }
        Product foundedProduct = findProduct(nameProduct);
        if(foundedProduct != null){
            repository.removeProduct(foundedProduct);
        }
    }

    @Override
    public Product findProduct(String nameProduct) throws NameInvalidException {
        if(nameProduct.isEmpty() || nameProduct.trim().isBlank()){
            throw new NameInvalidException(nameProduct);
        }
        for (Product product : products){
            if(product.getName() == nameProduct){
                return product;
            }
        }
        return null;
    }
}
