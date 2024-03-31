package exceptions;

public class EmployeeNotFoundException extends Exception {
    public EmployeeNotFoundException(){
        super("Funcionário não encontrado");
    }
}
