package dao;

import model.Client;

public interface ClientDao {
    void save(Client client);
    Client get();
}
