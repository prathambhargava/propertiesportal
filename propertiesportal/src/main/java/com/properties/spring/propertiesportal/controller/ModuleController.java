package com.properties.spring.propertiesportal.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.properties.spring.propertiesportal.entity.Module;
import com.properties.spring.propertiesportal.entity.Client;
import com.properties.spring.propertiesportal.repository.ClientRepository;
import com.properties.spring.propertiesportal.repository.ModuleRepository;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/modules")
public class ModuleController {
    @Autowired
    private ModuleRepository moduleRepository;

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/{clientId}")
    public List<Module> getModulesByClientId(@PathVariable String clientId) {
        Optional<Client> client = clientRepository.findById(clientId);
        if (client.isPresent()) {
            return moduleRepository.findByClient(client.get());
        } else {
            throw new EntityNotFoundException("Client not found with id: " + clientId);
        }
    }
}
