package org.dnsalias.muppets.poc.swagger.starterdemo.service;

import java.util.List;

import org.dnsalias.muppets.poc.swagger.starterdemo.entity.ProgramProfile;

public interface IProgramProfileService {

	ProgramProfile getProgramProfileById(Integer id);

	List<ProgramProfile> getAllProgramProfiles();

	ProgramProfile addProgramProfile(ProgramProfile programProfile);

	void updateProgramProfile(ProgramProfile programProfile);

	void deleteProgramProfile(Integer id);
	
}
