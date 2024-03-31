package exceptions;

public class DrugstoreNotFoundException extends Exception {
    public DrugstoreNotFoundException(){
        super("Drogaria não encontrada!");
    }
}
