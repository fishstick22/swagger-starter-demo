package org.dnsalias.muppets.poc.swagger.starterdemo.service;

import java.util.List;

import org.dnsalias.muppets.poc.swagger.starterdemo.entity.ProgramProfileClientException;

public interface IProgramProfileClientExceptionService {

	ProgramProfileClientException getProgramProfileClientExceptionById(Integer id);

	List<ProgramProfileClientException> getAllProgramProfileClientExceptions();

	ProgramProfileClientException addProgramProfileClientException(ProgramProfileClientException programProfileClientException);

	void updateProgramProfileClientException(ProgramProfileClientException programProfileClientException);

	void deleteProgramProfileClientException(Integer id);
	
}
