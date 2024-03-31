package services;

import entities.Client;
import entities.Product;
import exceptions.*;
import interfaces.repositories.IClientRepository;
import interfaces.services.IClientService;
import interfaces.services.IEmployeeClientService;
import interfaces.services.IProductClientService;
import repositories.ClientRepository;

import javax.xml.namespace.QName;
import java.util.ArrayList;

public class ClientService implements IClientService {
    private IClientRepository repository = new ClientRepository();
    private ArrayList<Client> clients = repository.getClients();
    @Override
    public void addClient(String name, int document, int telephone) throws ClientException, NameInvalidException, DocumentInvalidException {
        if(name == null || document < 0 || telephone < 0) {
            throw new ClientException("Cliente inválido!");
        }
        Client client = new Client(name, document, telephone);
        if (client.getName() == null || client.getName().trim().isEmpty() || client.getName().length() < 3) {
            throw new NameInvalidException(name);
        }else if(client.getDocument() < 8 || client.getDocument() > 14){
            throw new DocumentInvalidException(client.getDocument());
        }
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
    public void change(String oldClientName, Client newClient) throws NameInvalidException, DocumentInvalidException, ClientException {
        if(oldClientName == null || oldClientName.trim().isEmpty() || oldClientName.trim().isBlank()){
            throw new NameInvalidException(oldClientName);
        }else if (newClient.getName() == null || newClient.getName().trim().isEmpty() || newClient.getName().length() < 3) {
            throw new NameInvalidException(newClient.getName());
        }else if(newClient.getDocument() < 8 || newClient.getDocument() > 14){
            throw new DocumentInvalidException(newClient.getDocument());
        }else{
            Client foundedClient = findClient(oldClientName);
            if(foundedClient != null){
                repository.changeClient(clients.indexOf(foundedClient), newClient);
            }else{
                throw new ClientNotFoundException();
            }
        }
    }

    @Override
    public void deleteClient(String name) throws NameInvalidException, ClientException {
        if(name == null || name.trim().isEmpty() || name.trim().isBlank()){
            throw new NameInvalidException(name);
        }
        Client foundedClient = findClient(name);
        if(foundedClient != null){
            repository.removeClient(foundedClient);
        }else{
            throw new ClientNotFoundException();
        }
    }

    @Override
    public void addProductToCart(String nameProduct, String clientName) throws NameInvalidException, ProductNotFoundException, ClientNotFoundException {
        IProductClientService productService = new ProductService();
        Product foundedProduct = productService.findProduct(nameProduct);
        Client foundedClient = findClient(clientName);

        if(foundedProduct == null){
            throw new ProductNotFoundException();
        }else if(foundedClient == null){
            throw new ClientNotFoundException();
        }else{
            foundedClient.getCart().add(foundedProduct);
        }
    }

    @Override
    public void buyProducts(String nameClient, int cashierNumber) throws NameInvalidException, CashierInvalidException {
        IEmployeeClientService employeeClientService = new EmployeeService();
        if(nameClient == null || nameClient.trim().isBlank() || nameClient.isEmpty()){
            throw new NameInvalidException(nameClient);
        }else if(cashierNumber < 0){
            throw new CashierInvalidException();
        }
        employeeClientService.startSale(findClient(nameClient), cashierNumber);
    }

    @Override
    public void requestAnAppointment() {
        /* lógica de fazer uma consulta */
    }

    @Override
    public Client findClient(String name) throws NameInvalidException {
        if(name == null || name.trim().isBlank() || name.isEmpty()){
            throw new NameInvalidException(name);
        }
        for (Client client : clients){
            if(client.getName().equals(name)){
                return client;
            }
        }
        return null;
    }

}
