package exceptions;

public class ClientNotFoundException extends ClientException {
    public ClientNotFoundException() {
        super("Cliente não e ncontrado!");
    }
}
