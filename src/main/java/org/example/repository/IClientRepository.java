package org.example.repository;

import org.example.model.Client;

import java.util.ArrayList;

public interface IClientRepository {

    void add(Client client);
    void deleteById(Long id);
    ArrayList findAll();
    public Long nextIdAvailable();
    Client findById(Long id);
    Client findByDni(String dni);
    void update(Client client);

}
