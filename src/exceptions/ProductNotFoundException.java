package exceptions;

public class ProductNotFoundException extends Exception {
    public ProductNotFoundException(){
        super("Produto inválido!");
    }
}
