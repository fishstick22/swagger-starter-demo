package org.dnsalias.muppets.poc.swagger.starterdemo.service;

import java.util.List;

import org.dnsalias.muppets.poc.swagger.starterdemo.entity.ProgramConfiguration;
import org.dnsalias.muppets.poc.swagger.starterdemo.repository.ProgramConfigurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProgramConfigurationService implements IProgramConfigurationService {

	@Autowired
	private ProgramConfigurationRepository programConfigurationDAO;

	@Override
	public ProgramConfiguration getProgramConfigurationById(Integer id) {
		ProgramConfiguration obj = programConfigurationDAO.findById(id).get();
		return obj;
	}

	@Override
	public List<ProgramConfiguration> getAllProgramConfigurations() {
		return programConfigurationDAO.findAll();
	}

	@Override
	public ProgramConfiguration addProgramConfiguration(ProgramConfiguration programConfiguration) {
		return programConfigurationDAO.save(programConfiguration);
	}

	@Override
	public void updateProgramConfiguration(ProgramConfiguration programConfiguration) {
		programConfigurationDAO.save(programConfiguration);
		
	}

	@Override
	public void deleteProgramConfiguration(Integer id) {
		programConfigurationDAO.deleteById(id);
		
	}
}
