package interfaces.repositories;

import entities.Client;

import java.util.ArrayList;

public interface IClientRepository {
    public void saveClient(Client client);
    public void changeClient(int index, Client newClient);
    public ArrayList<Client> getClients();
    public void removeClient(Client client);
}
