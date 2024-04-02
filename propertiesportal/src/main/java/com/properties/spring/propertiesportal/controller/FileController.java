package com.properties.spring.propertiesportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.properties.spring.propertiesportal.entity.Client;
import com.properties.spring.propertiesportal.entity.Module;
import com.properties.spring.propertiesportal.service.ClientService;
import com.properties.spring.propertiesportal.service.ModuleService;

@RestController
@RequestMapping("/api")
public class FileController {

	@Autowired
	private ClientService clientService;

	@Autowired
	private ModuleService moduleService;

	// Get all clients
	@GetMapping("/clients")
	public List<Client> getAllClients() {
		return clientService.getAllClients();
	}

	//get client by id
	@GetMapping("/clients/{clientId}")
	public Client getClientById(@PathVariable String clientId) {
		return clientService.getClientById(clientId);
	}

	// create new clients
	@PostMapping("/clients")
	public Client createClient(@RequestBody Client client) {
		return clientService.createClient(client);

	}

	// Get all module files for a client
	@GetMapping("/clients/{clientId}/modulefiles")
	public List<Module> getModuleByClientId(@PathVariable String clientId) {
		return moduleService.getModuleByClientId(clientId);
	}

	// Create a new module file
	@PostMapping("/module")
	public Module createModuleFile(@RequestBody Module module) {
		return moduleService.createModule(module);
	}

	// Update an existing module file
	@PutMapping("/modulefiles/{moduleId}")
	public Module updateModule(@PathVariable String moduleId, @RequestBody Module module) {
		return moduleService.updateModule(moduleId, module);
	}

	// Delete a module file
	@DeleteMapping("/modulefiles/{moduleId}")
	public void deleteModule(@PathVariable String moduleId) {
		moduleService.deleteModule(moduleId);
	}

}
