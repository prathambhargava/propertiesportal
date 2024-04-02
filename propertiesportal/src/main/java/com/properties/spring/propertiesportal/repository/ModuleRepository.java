package com.properties.spring.propertiesportal.repository;
import java.util.List;
import com.properties.spring.propertiesportal.entity.Module;
import com.properties.spring.propertiesportal.entity.Client;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ModuleRepository extends MongoRepository<Module, String> {
    List<Module> findByClient(Client client);
}