package interfaces.services;

import entities.Client;
import exceptions.CashierException;

public interface IEmployeeClientService {
    public void startSale(Client client, int Number) throws CashierException;
}
