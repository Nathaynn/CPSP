package com.mitiara.backend.services;

import com.mitiara.backend.dtos.ClientNameDTO;
import com.mitiara.backend.models.Client;
import com.mitiara.backend.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService{

    @Autowired
    private ClientRepository clientRepository;

    // create operation
    @Override
    public ResponseEntity<Object> saveClient(Client client) {
        try {
            clientRepository.save(client);
            return ResponseEntity.ok(client);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: Unable to save Client. " + e.getMessage());
        }
    }

    // read operation
    @Override
    public ResponseEntity<Object> fetchClient(Integer id) {
        Optional<Client> client = clientRepository.findById(id);

        if (client.isPresent()) {
            return ResponseEntity.ok(client.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // update operations
    @Override
    public ResponseEntity<Object> updateEmail(Integer id, String email) {
        Optional<Client> client = clientRepository.findById(id);

        if (client.isPresent()) {
            Client saved = client.get();
            saved.setEmail(email);
            try {
                clientRepository.save(saved);
                return ResponseEntity.ok(saved);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body("Error: Unable to save Client. " + e.getMessage());
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Object> updatePassword(Integer id, String password) {
        Optional<Client> client = clientRepository.findById(id);

        if (client.isPresent()) {
            Client saved = client.get();
            saved.setPassword(password);
            try {
                clientRepository.save(saved);
                return ResponseEntity.ok(saved);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body("Error: Unable to save Client. " + e.getMessage());
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Object> updateName(Integer id, ClientNameDTO name) {
        Optional<Client> client = clientRepository.findById(id);

        if (client.isPresent()) {
            Client saved = client.get();
            saved.setFirstName(name.getFirstName());
            saved.setLastName(name.getLastName());
            try {
                clientRepository.save(saved);
                return ResponseEntity.ok(saved);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body("Error: Unable to save Client. " + e.getMessage());
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Object> updateUsername(Integer id, String username) {
        Optional<Client> client = clientRepository.findById(id);
        if (client.isPresent()) {
            Client saved = client.get();
            saved.setUsername(username);
            try {
                clientRepository.save(saved);
                return ResponseEntity.ok(saved);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body("Error: Unable to save Client. " + e.getMessage());
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Object> updatePhone(Integer id, String phone) {
        Optional<Client> client = clientRepository.findById(id);

        if (client.isPresent()) {
            Client saved = client.get();
            saved.setPhone(phone);
            try {
                clientRepository.save(saved);
                return ResponseEntity.ok(saved);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body("Error: Unable to save Client. " + e.getMessage());
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Object> updateBio(Integer id, String bio) {
        Optional<Client> client = clientRepository.findById(id);

        if (client.isPresent()) {
            Client saved = client.get();
            saved.setUserBio(bio);
            try {
                clientRepository.save(saved);
                return ResponseEntity.ok(saved);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body("Error: Unable to save Client. " + e.getMessage());
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // delete operation
    @Override
    public ResponseEntity<Void> deleteClient(Integer id) {
        Optional<Client> client = clientRepository.findById(id);

        if (client.isPresent()) {
            clientRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
