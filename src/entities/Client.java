package entities;

public class Client extends Pearson{
    private int login = getDocument();
    public Client(String name, String document, int telephone) {
        super(name, document, telephone);
    }

    public int getLogin() {
        return login;
    }

    public void setLogin(int login) {
        this.login = login;
    }
}
