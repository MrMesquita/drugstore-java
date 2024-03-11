package interfaces.services;

import entities.Client;

public interface IClientService {
    public void addClient(String name, int document, int telephone);
    public void printAll();
    public void change(String oldClientName, Client newClient);
    public void deleteClient(String name);
    public void addProductToCart(String nameProduct, String clientName);
    public void buyProducts(String nameClient, int cashierNumber);
    public void requestAnAppointment();
    public Client findClient(String name);
}
