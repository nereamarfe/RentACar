package org.example.repository;

import org.example.model.Client;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ClientRepositoryTest {

    ClientRepository repository;
    @BeforeEach
    void setUp() {
        repository = new ClientRepository();
        Client client1 = new Client("87896685P", "María", "Rodríguez");
        Client client2 = new Client("99687554K", "Nora", "Fernández");
        repository.add(client1);
        repository.add(client2);
    }

    @Test
    void add() {
        Client client3 = new Client("39887554G", "Pedro", "Fernández");
        repository.add(client3);
        Assertions.assertEquals(client3, repository.findById(3L));
        Client client4 = new Client("59887995L", "Juan", "Pérez");
        repository.add(client4);
        Assertions.assertEquals(client4.getDni(), repository.findById(4L).getDni());
    }

    @Test
    void findAll() {
        Assertions.assertEquals(2, repository.findAll().size());
        Client client = new Client("48572039G", "Tamara", "Sánchez");
        repository.add(client);
        Assertions.assertEquals(3, repository.findAll().size());
    }

    @Test
    void deleteById() {
        Assertions.assertEquals(2, repository.findAll().size());
        repository.deleteById(3L); // Don't exist
        Assertions.assertEquals(2, repository.findAll().size());
        repository.deleteById(2L);
        Assertions.assertEquals(1, repository.findAll().size());
        repository.deleteById(1L);
        Assertions.assertEquals(0, repository.findAll().size());
    }

    @Test
    void nextIdAvailable() {
        Assertions.assertEquals(3, repository.nextIdAvailable());
        Client client = new Client("48572039G", "Tamara", "Sánchez");
        repository.add(client);
        Assertions.assertEquals(4, repository.nextIdAvailable());
        repository.deleteById(1L);
        Assertions.assertEquals(4, repository.nextIdAvailable());
    }

    @Test
    void findById() {
        Assertions.assertEquals("87896685P", repository.findById(1L).getDni());
        Assertions.assertEquals("Nora", repository.findById(2L).getName());
    }

}