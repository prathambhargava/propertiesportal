package com.properties.spring.propertiesportal.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/modules")
public class ModuleController {
	//    @Autowired
	//    private ModuleRepository moduleRepository;
	//
	//    @Autowired
	//    private ClientRepository clientRepository;
	//
	//    @GetMapping("/{clientId}")
	//    public List<Module> getModulesByClientId(@PathVariable String clientId) {
	//        Optional<Client> client = clientRepository.findById(clientId);
	//        if (client.isPresent()) {
	//            return moduleRepository.findByClient(client.get());
	//        } else {
	//            throw new EntityNotFoundException("Client not found with id: " + clientId);
	//        }
	//    }
}
