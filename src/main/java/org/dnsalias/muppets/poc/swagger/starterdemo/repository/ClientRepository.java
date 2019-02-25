package org.dnsalias.muppets.poc.swagger.starterdemo.repository;

import org.dnsalias.muppets.poc.swagger.starterdemo.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer>{

}
