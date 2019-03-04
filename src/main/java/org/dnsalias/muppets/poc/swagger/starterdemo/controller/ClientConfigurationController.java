package org.dnsalias.muppets.poc.swagger.starterdemo.controller;

import java.util.List;

import org.dnsalias.muppets.poc.swagger.starterdemo.entity.ClientConfiguration;
import org.dnsalias.muppets.poc.swagger.starterdemo.service.IClientConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import io.swagger.annotations.Api;

//@CrossOrigin
@Controller
@RequestMapping("/api")
@Api(tags = { "Clients Communication Configuration" })
public class ClientConfigurationController {

	@Autowired
	private IClientConfigurationService clientConfigurationService;
	
	
	@RequestMapping(value="/clientconfiguration/{id}", method = RequestMethod.GET )
	public ResponseEntity<ClientConfiguration> getClientConfigurationById(@PathVariable("id") Integer id) {
		ClientConfiguration clientConfiguration = clientConfigurationService.getClientConfigurationById(id);
		return new ResponseEntity<ClientConfiguration>(clientConfiguration, HttpStatus.OK);
	}
	
	@RequestMapping(value= "/clientconfiguration", method = RequestMethod.GET)
	public ResponseEntity<List<ClientConfiguration>> getAllClientConfigurations() {
		List<ClientConfiguration> list = clientConfigurationService.getAllClientConfigurations();
		return new ResponseEntity<List<ClientConfiguration>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value= "/clientconfiguration", method = RequestMethod.POST)
	public ResponseEntity<ClientConfiguration> addClientConfiguration(@RequestBody ClientConfiguration clientConfiguration, UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();
        ClientConfiguration result = clientConfigurationService.addClientConfiguration(clientConfiguration);
//        if (flag == false) {
//        	return new ResponseEntity<Void>(headers, HttpStatus.CONFLICT);
//        }

        headers.setLocation(builder.path("/clientconfiguration/{id}").buildAndExpand(clientConfiguration.getId()).toUri());
        return new ResponseEntity<ClientConfiguration>(result, headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/clientconfiguration/{id}", method = RequestMethod.PUT )
	public ResponseEntity<ClientConfiguration> updateClientConfiguration(@PathVariable("id") Integer id, @RequestBody ClientConfiguration clientConfiguration) {
		clientConfigurationService.updateClientConfiguration(clientConfiguration);
		return new ResponseEntity<ClientConfiguration>(clientConfiguration, HttpStatus.OK);
	}
	
	@RequestMapping(value="/clientconfiguration/{id}", method = RequestMethod.DELETE )
	public ResponseEntity<Void> deleteClientConfiguration(@PathVariable("id") Integer id) {
		clientConfigurationService.deleteClientConfiguration(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
