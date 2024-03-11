package services;

import entities.Drug;
import entities.Product;
import interfaces.services.IProductClientService;
import interfaces.services.IProductService;
import interfaces.repositories.IProductRepository;
import repositories.ProductRepository;

import java.util.ArrayList;

public class ProductService implements IProductService, IProductClientService {
    private IProductRepository repository = new ProductRepository();
    private ArrayList<Product> products = repository.getProducts();
    @Override
    public void addProduct(String name, float barcode, double price) {
        Product product = new Product(name, barcode, price);
        if(product != null){
            repository.saveProduct(product);
        }
    }

    @Override
    public void changeProduct(String name, Product newProduct) {
        Product foundedProduct = findProduct(name);
        if(foundedProduct != null){
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
    public void deleteProduct(String nameProduct) {
        Product foundedProduct = findProduct(nameProduct);
        if(foundedProduct != null){
            repository.removeProduct(foundedProduct);
        }
    }

    @Override
    public Product findProduct(String nameProduct) {
        for (Product product : products){
            if(product.getName() == nameProduct){
                return product;
            }
        }
        return null;
    }
}
