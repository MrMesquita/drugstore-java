package repositories;

import entities.Client;
import interfaces.repositories.IClientRepository;

import java.util.ArrayList;

public class ClientRepository implements IClientRepository {
    private ArrayList<Client> clients = new ArrayList<>();
    @Override
    public void saveClient(Client client) {
        clients.add(client);
    }

    @Override
    public void changeClient(int index, Client newClient) {
        clients.set(index, newClient);
    }

    @Override
    public ArrayList<Client> getClients() {
        return clients;
    }

    @Override
    public void removeClient(Client client) {
        clients.remove(client);
    }
}
