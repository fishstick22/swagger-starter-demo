package org.dnsalias.muppets.poc.swagger.starterdemo.service;

import java.util.List;

import org.dnsalias.muppets.poc.swagger.starterdemo.entity.Client;
import org.dnsalias.muppets.poc.swagger.starterdemo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService implements IClientService {

	@Autowired
	private ClientRepository clientDAO;
	
	@Override
	public Client getClientById(Integer id) {
		Client obj = clientDAO.findById(id).get();
		return obj;
	}

	@Override
	public List<Client> getAllClients() {
		return clientDAO.findAll();
	}

}
