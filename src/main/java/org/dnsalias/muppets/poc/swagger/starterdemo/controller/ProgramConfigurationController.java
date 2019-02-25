package org.dnsalias.muppets.poc.swagger.starterdemo.controller;

import java.util.List;

import org.dnsalias.muppets.poc.swagger.starterdemo.entity.ProgramConfiguration;
import org.dnsalias.muppets.poc.swagger.starterdemo.service.IProgramConfigurationService;
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

@CrossOrigin
@Controller
@RequestMapping("/api")
public class ProgramConfigurationController {

	@Autowired
	private IProgramConfigurationService programConfigurationService;
	
	
	@RequestMapping(value="/programconfiguration/{id}", method = RequestMethod.GET )
	public ResponseEntity<ProgramConfiguration> getProgramConfigurationById(@PathVariable("id") Integer id) {
		ProgramConfiguration programConfiguration = programConfigurationService.getProgramConfigurationById(id);
		return new ResponseEntity<ProgramConfiguration>(programConfiguration, HttpStatus.OK);
	}
	
	@RequestMapping(value= "/programconfiguration", method = RequestMethod.GET)
	public ResponseEntity<List<ProgramConfiguration>> getAllProgramConfigurations() {
		List<ProgramConfiguration> list = programConfigurationService.getAllProgramConfigurations();
		return new ResponseEntity<List<ProgramConfiguration>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value= "/programconfiguration", method = RequestMethod.POST)
	public ResponseEntity<ProgramConfiguration> addProgramConfiguration(@RequestBody ProgramConfiguration programConfiguration, UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();
        ProgramConfiguration result = programConfigurationService.addProgramConfiguration(programConfiguration);
//        if (flag == false) {
//        	return new ResponseEntity<Void>(headers, HttpStatus.CONFLICT);
//        }

        headers.setLocation(builder.path("/programconfiguration/{id}").buildAndExpand(programConfiguration.getId()).toUri());
        return new ResponseEntity<ProgramConfiguration>(result, headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/programconfiguration/{id}", method = RequestMethod.PUT )
	public ResponseEntity<ProgramConfiguration> updateProgramConfiguration(@RequestBody ProgramConfiguration programConfiguration) {
		programConfigurationService.updateProgramConfiguration(programConfiguration);
		return new ResponseEntity<ProgramConfiguration>(programConfiguration, HttpStatus.OK);
	}
	
	@RequestMapping(value="/programconfiguration/{id}", method = RequestMethod.DELETE )
	public ResponseEntity<Void> deleteProgramConfiguration(@PathVariable("id") Integer id) {
		programConfigurationService.deleteProgramConfiguration(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
