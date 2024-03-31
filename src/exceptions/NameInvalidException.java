package exceptions;

public class NameInvalidException extends PersonException {
    public NameInvalidException(String name){
        super("Nome inválido. "+name);
    }
}
