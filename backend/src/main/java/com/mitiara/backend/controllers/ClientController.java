package com.mitiara.backend.controllers;

import com.mitiara.backend.dtos.ClientNameDTO;
import com.mitiara.backend.models.Client;
import com.mitiara.backend.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/client")
public class ClientController {

    @Autowired
    public ClientService clientService;

    @GetMapping("/")
    public ResponseEntity<String> testClient() {
        return ResponseEntity.ok("Success");
    }

    // create operation
    @PostMapping("/")
    public ResponseEntity<Object> saveClient(@RequestBody Client client) {
        return clientService.saveClient(client);
    }

    // read operation
    @GetMapping("/{id}")
    public ResponseEntity<Object> fetchClient(@PathVariable("id") Integer id) {
        return clientService.fetchClient(id);
    }

    // update operations
    @PutMapping("/email/{id}")
    public ResponseEntity<Object> updateEmail(@PathVariable("id") Integer id, @RequestBody String email) {
        return clientService.updateEmail(id, email);
    }

    @PutMapping("/password/{id}")
    public ResponseEntity<Object> updatePassword(@PathVariable("id") Integer id, @RequestBody String password) {
        return clientService.updatePassword(id, password);
    }

    @PutMapping("/name/{id}")
    public ResponseEntity<Object> updatePassword(@PathVariable("id") Integer id, @RequestBody ClientNameDTO name) {
        return clientService.updateName(id, name);
    }

    @PutMapping("/username/{id}")
    public ResponseEntity<Object> updateUsername(@PathVariable("id") Integer id, @RequestBody String username) {
        return clientService.updateUsername(id, username);
    }

    @PutMapping("/phone/{id}")
    public ResponseEntity<Object> updatePhone(@PathVariable("id") Integer id, @RequestBody String phone) {
        return clientService.updatePhone(id, phone);
    }

    @PutMapping("/bio/{id}")
    public ResponseEntity<Object> updateBio(@PathVariable("id") Integer id, @RequestBody String bio) {
        return clientService.updateBio(id, bio);
    }

    // delete operation
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable("id") Integer id) {
        return clientService.deleteClient(id);
    }




}
