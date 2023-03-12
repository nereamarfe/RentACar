package org.example.service;

import org.example.model.Client;
import org.example.repository.ClientRepository;
import org.example.repository.IClientRepository;

import java.util.ArrayList;

public class ClientServiceImpl implements IClientService{

    private IClientRepository repository;
    public ClientServiceImpl() {
        repository = new ClientRepository();
    }

    @Override
    public void add(Client client) {
        repository.add(client);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public ArrayList findAll() {
        return repository.findAll();
    }

    @Override
    public Client findByDni(String dni) {
        return repository.findByDni(dni);
    }

    @Override
    public void update(Client client) {
        repository.update(client);
    }


}
