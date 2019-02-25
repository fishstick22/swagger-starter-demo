package org.dnsalias.muppets.poc.swagger.starterdemo.service;

import java.util.List;

import org.dnsalias.muppets.poc.swagger.starterdemo.entity.ClientConfiguration;
import org.dnsalias.muppets.poc.swagger.starterdemo.repository.ClientConfigurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientConfigurationService implements IClientConfigurationService{

	@Autowired
	private ClientConfigurationRepository clientConfigurationDAO;

	@Override
	public ClientConfiguration getClientConfigurationById(Integer id) {
		ClientConfiguration obj = clientConfigurationDAO.findById(id).get();
		return obj;
	}

	@Override
	public List<ClientConfiguration> getAllClientConfigurations() {
		return clientConfigurationDAO.findAll();
	}

	@Override
	public ClientConfiguration addClientConfiguration(ClientConfiguration clientConfiguration) {
		return clientConfigurationDAO.save(clientConfiguration);
	}

	@Override
	public void updateClientConfiguration(ClientConfiguration clientConfiguration) {
		clientConfigurationDAO.save(clientConfiguration);
		
	}

	@Override
	public void deleteClientConfiguration(Integer id) {
		clientConfigurationDAO.deleteById(id);
		
	}
}
