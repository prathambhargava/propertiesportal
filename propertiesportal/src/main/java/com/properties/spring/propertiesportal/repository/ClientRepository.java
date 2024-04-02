package com.properties.spring.propertiesportal.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.properties.spring.propertiesportal.entity.Client;

@Repository
public interface ClientRepository extends MongoRepository<Client, String> {
	Client findByClientId(String clientId);
}