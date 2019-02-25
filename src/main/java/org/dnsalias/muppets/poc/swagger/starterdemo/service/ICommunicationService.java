package org.dnsalias.muppets.poc.swagger.starterdemo.service;

import java.util.List;

import org.dnsalias.muppets.poc.swagger.starterdemo.entity.Communication;

public interface ICommunicationService {

	Communication getCommunicationById(Integer id);

	List<Communication> getAllCommunications();
}
