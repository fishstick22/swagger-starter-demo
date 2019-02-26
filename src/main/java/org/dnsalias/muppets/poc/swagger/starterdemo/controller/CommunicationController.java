package org.dnsalias.muppets.poc.swagger.starterdemo.controller;

import java.util.List;

import org.dnsalias.muppets.poc.swagger.starterdemo.entity.Communication;
import org.dnsalias.muppets.poc.swagger.starterdemo.service.ICommunicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.Api;

//http://docs.spring.io/spring/docs/current/spring-framework-reference/html/cors.html
@CrossOrigin 
@Controller
@RequestMapping("/api")
@Api(tags = { "Communcations" })
public class CommunicationController {

	@Autowired
	private ICommunicationService communicationService;
	
	@RequestMapping(value="/communication/{id}", method = RequestMethod.GET )
	public ResponseEntity<Communication> getCommunicationById(@PathVariable("id") Integer id) {
		Communication communication = communicationService.getCommunicationById(id);
		return new ResponseEntity<Communication>(communication, HttpStatus.OK);
	}
	
	@RequestMapping(value= "/communication", method = RequestMethod.GET)
	public ResponseEntity<List<Communication>> getAllCommunications() {
		List<Communication> list = communicationService.getAllCommunications();
		return new ResponseEntity<List<Communication>>(list, HttpStatus.OK);
	}
}
