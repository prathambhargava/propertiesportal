package com.properties.spring.propertiesportal.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.properties.spring.propertiesportal.entity.Module;

@Repository
public interface ModuleRepository extends MongoRepository<Module, String> {
	List<Module> findByClientId(String clientId);
}