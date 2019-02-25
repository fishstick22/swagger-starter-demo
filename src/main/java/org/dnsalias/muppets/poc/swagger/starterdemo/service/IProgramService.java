package org.dnsalias.muppets.poc.swagger.starterdemo.service;

import java.util.List;

import org.dnsalias.muppets.poc.swagger.starterdemo.entity.Program;

public interface IProgramService {

	Program getProgramById(Integer id);

	List<Program> getAllPrograms();

	boolean addProgram(Program program);

	void updateProgram(Program program);

	void deleteProgram(Integer id);
}
