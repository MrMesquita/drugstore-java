package exceptions;

import entities.Sale;

public class SaleNotFoundException extends Exception {
    public SaleNotFoundException() {
        super("Venda não encontrada");
    }
}
