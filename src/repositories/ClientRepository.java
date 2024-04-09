package repositories;

import entities.Client;
import interfaces.repositories.IClientRepository;

public class ClientRepository implements IClientRepository {
    private FilaClientes clients = new FilaClientes();
    @Override
    public void saveClient(Client client) {
        clients.enqueue(client);
    }

    @Override
    public void changeClient(int index, Client newClient) {
        clients.set(index, newClient);
    }

    @Override
    public FilaClientes getClients() {
        return clients;
    }

    public void printFila(){
        clients.printFila();
    }

    @Override
    public void removeClient(Client client) {
        clients.dequeue();
    }
}
