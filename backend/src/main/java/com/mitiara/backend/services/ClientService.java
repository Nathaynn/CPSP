package com.mitiara.backend.services;

import com.mitiara.backend.dtos.ClientNameDTO;
import com.mitiara.backend.models.Client;
import org.springframework.http.ResponseEntity;

public interface ClientService {

    // create operation
    ResponseEntity<Object> saveClient(Client client);

    // read operation
    ResponseEntity<Object> fetchClient(Integer id);

    // update operations
    ResponseEntity<Object> updateEmail(Integer id, String email);

    ResponseEntity<Object> updatePassword(Integer id, String password);

    ResponseEntity<Object> updateName(Integer id, ClientNameDTO clientName);

    ResponseEntity<Object> updateUsername(Integer id, String username);

    ResponseEntity<Object> updatePhone(Integer id, String phone);

    ResponseEntity<Object> updateBio(Integer id, String bio);

    // delete operation
    ResponseEntity<Void> deleteClient(Integer id);
}