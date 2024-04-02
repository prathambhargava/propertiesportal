package com.properties.spring.propertiesportal.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.properties.spring.propertiesportal.entity.Module;
import com.properties.spring.propertiesportal.repository.ModuleRepository;

@Service
public class ModuleService {

	@Autowired
	private ModuleRepository moduleRepository;

	public List<Module> getModuleByClientId(String clientId) {
		return moduleRepository.findByClientId(clientId);
	}

	// Get module names by client ID
	public List<String> getModuleNamesByClientId(String clientId) {
		List<Module> moduleFiles = moduleRepository.findByClientId(clientId);
		return moduleFiles.stream().map(Module::getModuleName) // Assuming you have a method to get module name
				.distinct().collect(Collectors.toList());
	}

	// Create a new module file
	public Module createModule(Module module) {
		return moduleRepository.save(module);
	}

	// Delete a module file
	public void deleteModule(String moduleId) {
		moduleRepository.deleteById(moduleId);
	}

	public Optional<String> readFileContent(String filePath) {
		try {
			return Optional.of(new String(Files.readAllBytes(Paths.get(filePath))));
		} catch (IOException e) {
			e.printStackTrace();
			return Optional.empty();
		}
	}

	// Update an existing module file
	public Module updateModule(String moduleId, Module module) {
		Optional<Module> existingModuleOptional = moduleRepository.findById(moduleId);
		if (existingModuleOptional.isPresent()) {
			Module existingModule = existingModuleOptional.get();
			existingModule.setModuleName(module.getModuleName());
			existingModule.setClientId(module.getClientId());
			// Update other properties as needed
			return moduleRepository.save(existingModule);
		} else {
			// Handle error - module file not found
			return null;
		}
	}

	public void saveFileContent(String filePath, String content) {
		try {
			Files.write(Paths.get(filePath), content.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void uploadFile(MultipartFile file, String filePath) {
		try {
			byte[] bytes = file.getBytes();
			Files.write(Paths.get(filePath), bytes);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
