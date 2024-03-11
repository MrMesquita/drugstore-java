package entities;

import java.util.ArrayList;

public class Client extends Person {
    private int login = getDocument();
    private ArrayList<Product> cart;
    public Client(String name, int document, int telephone) {
        super(name, document, telephone);
        cart = new ArrayList<>();
    }

    public int getLogin() {
        return login;
    }

    public void setLogin(int login) {
        this.login = login;
    }

    public ArrayList<Product> getCart() {
        return cart;
    }

    public void setCart(ArrayList<Product> cart) {
        this.cart = cart;
    }
}
