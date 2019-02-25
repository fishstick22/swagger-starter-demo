package org.dnsalias.muppets.poc.swagger.starterdemo.service;

import java.util.List;

import org.dnsalias.muppets.poc.swagger.starterdemo.entity.ProgramProfile;
import org.dnsalias.muppets.poc.swagger.starterdemo.repository.ProgramProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProgramProfileService implements IProgramProfileService {

	@Autowired
	private ProgramProfileRepository programProfileDAO;

	@Override
	public ProgramProfile getProgramProfileById(Integer id) {
		ProgramProfile obj = programProfileDAO.findById(id).get();
		return obj;
	}

	@Override
	public List<ProgramProfile> getAllProgramProfiles() {
		return programProfileDAO.findAll();
	}

	@Override
	public ProgramProfile addProgramProfile(ProgramProfile programProfile) {
		return programProfileDAO.save(programProfile);
	}

	@Override
	public void updateProgramProfile(ProgramProfile programProfile) {
		programProfileDAO.save(programProfile);
		
	}

	@Override
	public void deleteProgramProfile(Integer id) {
		programProfileDAO.deleteById(id);
		
	}
}
