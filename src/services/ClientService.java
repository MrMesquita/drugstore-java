package services;

import entities.Client;
import entities.Product;
import interfaces.repositories.IClientRepository;
import interfaces.services.IClientService;
import interfaces.services.IEmployeeClientService;
import interfaces.services.IProductClientService;
import repositories.ClientRepository;

import java.util.ArrayList;

public class ClientService implements IClientService {
    private IClientRepository repository = new ClientRepository();
    private ArrayList<Client> clients = repository.getClients();
    @Override
    public void addClient(String name, int document, int telephone) {
        Client client = new Client(name, document, telephone);
        if(client != null){
            repository.saveClient(client);
        }
    }

    @Override
    public void printAll() {
        for (Client client : clients){
            System.out.println(
                "Nome: "+client.getName()+
                "\nDocumento: "+client.getDocument()+
                "\nTelefone: "+client.getTelephone()
            );
        }
    }

    @Override
    public void change(String oldClientName, Client newClient) {
        Client foundedClient = findClient(oldClientName);
        if(foundedClient != null){
            repository.changeClient(clients.indexOf(foundedClient), newClient);
        }
    }

    @Override
    public void deleteClient(String name) {
        Client foundedClient = findClient(name);
        if(foundedClient != null){
            repository.removeClient(foundedClient);
        }
    }

    @Override
    public void addProductToCart(String nameProduct, String clientName) {
        IProductClientService productService = new ProductService();

        Product foundedProduct = productService.findProduct(nameProduct);
        Client foundedClient = findClient(clientName);
        foundedClient.getCart().add(foundedProduct);
    }

    @Override
    public void buyProducts(String nameClient, int cashierNumber) {
        IEmployeeClientService employeeClientService = new EmployeeService();
        employeeClientService.startSale(findClient(nameClient), cashierNumber);
    }

    @Override
    public void requestAnAppointment() {

    }

    @Override
    public Client findClient(String name) {
        for (Client client : clients){
            if(client.getName() == name){
                return client;
            }
        }
        return null;
    }

}
