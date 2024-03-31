package interfaces.services;

import entities.Client;
import exceptions.*;

public interface IClientService {
    public void addClient(String name, int document, int telephone) throws ClientException, NameInvalidException, DocumentInvalidException;
    public void printAll();
    public void change(String oldClientName, Client newClient) throws NameInvalidException, DocumentInvalidException, ClientException;
    public void deleteClient(String name) throws NameInvalidException, ClientException;
    public void addProductToCart(String nameProduct, String clientName) throws NameInvalidException, ProductNotFoundException, ClientNotFoundException;
    public void buyProducts(String nameClient, int cashierNumber) throws NameInvalidException, CashierInvalidException;
    public void requestAnAppointment();
    public Client findClient(String name) throws NameInvalidException;
}
