package interfaces.repositories;

import entities.Client;
import repositories.FilaClientes;

public interface IClientRepository {
    public void saveClient(Client client);
    public void changeClient(int index, Client newClient);
    public FilaClientes getClients();
    public void printFila();
    public void removeClient(Client client);
}
