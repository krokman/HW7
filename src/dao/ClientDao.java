package dao;

import model.Client;

import java.util.List;

public interface ClientDao {
    void saveClient(Client client);
    Client getClient();
    List<Client> getAllClients();
}
