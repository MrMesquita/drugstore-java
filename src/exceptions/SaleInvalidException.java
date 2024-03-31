package exceptions;

import entities.Sale;

public class SaleInvalidException extends Throwable {
    public SaleInvalidException(Sale sale) {
        super("A venda: "+sale+" é inválida");
    }
}
