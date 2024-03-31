package exceptions;

public class EmployeeCodeInvalidException extends PersonException{
    public EmployeeCodeInvalidException(int code) {
        super("Código de funcionário inválido: "+code);
    }
}
