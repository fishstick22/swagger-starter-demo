package org.dnsalias.muppets.poc.swagger.starterdemo.service;

import java.util.List;

import org.dnsalias.muppets.poc.swagger.starterdemo.entity.Client;

public interface IClientService {
	
	Client getClientById(Integer id);
	
	List<Client> getAllClients();
}
