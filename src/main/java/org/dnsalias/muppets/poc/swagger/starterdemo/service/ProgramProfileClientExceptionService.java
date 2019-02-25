package org.dnsalias.muppets.poc.swagger.starterdemo.service;

import java.util.List;

import org.dnsalias.muppets.poc.swagger.starterdemo.entity.ProgramProfileClientException;
import org.dnsalias.muppets.poc.swagger.starterdemo.repository.ProgramProfileClientExceptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProgramProfileClientExceptionService implements IProgramProfileClientExceptionService {

	@Autowired
	private ProgramProfileClientExceptionRepository programProfileClientExceptionDAO;

	@Override
	public ProgramProfileClientException getProgramProfileClientExceptionById(Integer id) {
		ProgramProfileClientException obj = programProfileClientExceptionDAO.findById(id).get();
		return obj;
	}

	@Override
	public List<ProgramProfileClientException> getAllProgramProfileClientExceptions() {
		return programProfileClientExceptionDAO.findAll();
	}

	@Override
	public ProgramProfileClientException addProgramProfileClientException(ProgramProfileClientException programProfileClientException) {
		return programProfileClientExceptionDAO.save(programProfileClientException);
	}

	@Override
	public void updateProgramProfileClientException(ProgramProfileClientException programProfileClientException) {
		programProfileClientExceptionDAO.save(programProfileClientException);
		
	}

	@Override
	public void deleteProgramProfileClientException(Integer id) {
		programProfileClientExceptionDAO.deleteById(id);
		
	}
}
