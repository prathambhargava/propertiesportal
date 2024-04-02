package com.properties.spring.propertiesportal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.properties.spring.propertiesportal.entity.Client;
import com.properties.spring.propertiesportal.repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;

	public List<Client> getAllClients() {
		return clientRepository.findAll();
	}

	public Client getClientById(String id) {
		Client client = clientRepository.findByClientId(id);
		return (client != null) ? client : null;
	}

	public Client createClient(Client client) {
		return clientRepository.save(client);
	}

	public Client updateClient(String id, Client client) {
		Optional<Client> existingClientOptional = clientRepository.findById(id);
		if (existingClientOptional.isPresent()) {
			Client existingClient = existingClientOptional.get();
			existingClient.setClientId(client.getClientId());
			existingClient.setClientName(client.getClientName());
			return clientRepository.save(existingClient);
		} else {
			// Handle error - client not found
			return null;
		}
	}

	public void deleteClient(String id) {
		clientRepository.deleteById(id);
	}
}