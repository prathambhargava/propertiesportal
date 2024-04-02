package com.properties.spring.propertiesportal.repository;

import com.properties.spring.propertiesportal.entity.*;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientRepository extends MongoRepository<Client, String> {
}