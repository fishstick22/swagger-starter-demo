package org.dnsalias.muppets.poc.swagger.starterdemo.service;

import java.util.List;

import org.dnsalias.muppets.poc.swagger.starterdemo.entity.ProgramConfiguration;

public interface IProgramConfigurationService {

	ProgramConfiguration getProgramConfigurationById(Integer id);

	List<ProgramConfiguration> getAllProgramConfigurations();

	ProgramConfiguration addProgramConfiguration(ProgramConfiguration programConfiguration);

	void updateProgramConfiguration(ProgramConfiguration programConfiguration);

	void deleteProgramConfiguration(Integer id);
	
}
