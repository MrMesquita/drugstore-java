package exceptions;

import entities.Product;

public class ProductInvalidException extends Throwable {
    public ProductInvalidException(Product newProduct) {
        super("O produto é invalido! "+ newProduct.getName());
    }
}
