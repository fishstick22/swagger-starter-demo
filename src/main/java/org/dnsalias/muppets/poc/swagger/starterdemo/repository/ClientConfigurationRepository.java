package org.dnsalias.muppets.poc.swagger.starterdemo.repository;

import org.dnsalias.muppets.poc.swagger.starterdemo.entity.ClientConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientConfigurationRepository extends JpaRepository<ClientConfiguration, Integer>{

}
