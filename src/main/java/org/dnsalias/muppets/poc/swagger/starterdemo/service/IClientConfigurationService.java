package org.dnsalias.muppets.poc.swagger.starterdemo.service;

import java.util.List;

import org.dnsalias.muppets.poc.swagger.starterdemo.entity.ClientConfiguration;

public interface IClientConfigurationService {

	ClientConfiguration getClientConfigurationById(Integer id);

	List<ClientConfiguration> getAllClientConfigurations();

	ClientConfiguration addClientConfiguration(ClientConfiguration programConfiguration);

	void updateClientConfiguration(ClientConfiguration programConfiguration);

	void deleteClientConfiguration(Integer id);
}
