package org.dnsalias.muppets.poc.swagger.starterdemo.service;

import java.util.List;

import org.dnsalias.muppets.poc.swagger.starterdemo.entity.Communication;
import org.dnsalias.muppets.poc.swagger.starterdemo.repository.CommunicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommunicationService implements ICommunicationService {

	@Autowired
	private CommunicationRepository communicationDAO;

	@Override
	public Communication getCommunicationById(Integer id) {
		Communication obj = communicationDAO.findById(id).get();
		return obj;
	}
	
	@Override
	public List<Communication> getAllCommunications() {
		return communicationDAO.findAll();
	}
	
}
