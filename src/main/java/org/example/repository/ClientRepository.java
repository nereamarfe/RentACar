package org.example.repository;

import org.example.model.Client;

import java.util.ArrayList;
import java.util.Iterator;

public class ClientRepository implements IClientRepository{

    private ArrayList<Client> clients;

    public ClientRepository() {
        clients = new ArrayList<>();
    }

    public void add(Client client){
        client.setId(nextIdAvailable());
        clients.add(client);
    }

    public void update(Client client){
        Client clientToUpdate = findById(client.getId());
        if(clientToUpdate != null){
            clientToUpdate.setDni(client.getDni());
            clientToUpdate.setName(client.getName());
            clientToUpdate.setSurname(client.getSurname());
        }
    }

    public ArrayList findAll(){
        return clients;
    }

    public void deleteById(Long id){
        if(!clients.isEmpty()) {
            Iterator<Client> iterator = clients.iterator();
            while (iterator.hasNext()){
                Client client = iterator.next();
                if (client.getId() == id) {
                    clients.remove(client);
                    break;
                }
            }
        }
    }

    public Long nextIdAvailable(){
        if(!clients.isEmpty()){
            return clients.get(clients.size()-1).getId() + 1;
        }
        else{
            return (long)1;
        }
    }

    public Client findById(Long id) {
        if(!clients.isEmpty()){
            for (Client client : clients) {
                if(client.getId() == id){
                    return client;
                }
            }
            return null;
        }
        return null;
    }



    public Client findByDni(String dni){
        if(!clients.isEmpty()){
            for (Client client : clients) {
                if(client.getDni().equals(dni)){
                    return client;
                }
            }
            return null;
        }
        return null;
    }

}
