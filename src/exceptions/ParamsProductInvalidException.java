package exceptions;

public class ParamsProductInvalidException extends Exception {
    public ParamsProductInvalidException(String name, float barcode, double price){
        super("Parâmetros inválidos! "+name+ " " +barcode+ " " +price);
    }
}
