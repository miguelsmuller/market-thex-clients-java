package com.thex.clients.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.thex.clients.model.ClientModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;


import com.thex.clients.repository.ClientRepository;

@RestController
public class ClientController {
    private final ClientRepository clientRepository;

    ClientController(ClientRepository repository) {
        this.clientRepository = repository;
    }

    @GetMapping("/health")
    public ResponseEntity<Map<String, String>> health() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Welcome to Java, Spring, and SQLite");
        response.put("status", "success");

        return ResponseEntity.ok(response);
    }

    @GetMapping("/clients")
    List<ClientModel> all() {
        return clientRepository.findAll();
    }

    @PostMapping("/clients")
    ClientModel newEmployee(@RequestBody ClientModel newClient) {
        return clientRepository.save(newClient);
    }

    @GetMapping("/clients/{ID}")
    ClientModel one(@PathVariable Long ID) {
        return clientRepository.findById(ID)
                .orElseThrow(() -> new ClientNotFoundException(ID));
    }

    @PutMapping("/clients/{id}")
    ClientModel replaceClient(@RequestBody ClientModel newClient, @PathVariable Long id) {
        return clientRepository.findById(id)
            .map(currentClient -> {
                currentClient.setFullName(newClient.getFullName());
                return clientRepository.save(currentClient);
            })
            .orElseGet(() -> {
                newClient.setId(id);
                return clientRepository.save(newClient);
            });
    }

    @DeleteMapping("/clients/{id}")
    ResponseEntity<?> deleteClient(@PathVariable Long id) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found");
        }
    }
}
