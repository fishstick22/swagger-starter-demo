package org.dnsalias.muppets.poc.swagger.starterdemo.controller;

import java.util.List;

import org.dnsalias.muppets.poc.swagger.starterdemo.entity.ProgramProfileClientException;
import org.dnsalias.muppets.poc.swagger.starterdemo.service.IProgramProfileClientExceptionService;
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
public class ProgramProfileClientExceptionController {

	@Autowired
	private IProgramProfileClientExceptionService programProfileClientExceptionService;
	
	
	@RequestMapping(value="/programprofileclientexception/{id}", method = RequestMethod.GET )
	public ResponseEntity<ProgramProfileClientException> getProgramProfileClientExceptionById(@PathVariable("id") Integer id) {
		ProgramProfileClientException programProfileClientException = programProfileClientExceptionService.getProgramProfileClientExceptionById(id);
		return new ResponseEntity<ProgramProfileClientException>(programProfileClientException, HttpStatus.OK);
	}
	
	@RequestMapping(value= "/programprofileclientexception", method = RequestMethod.GET)
	public ResponseEntity<List<ProgramProfileClientException>> getAllProgramProfileClientExceptions() {
		List<ProgramProfileClientException> list = programProfileClientExceptionService.getAllProgramProfileClientExceptions();
		return new ResponseEntity<List<ProgramProfileClientException>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value= "/programprofileclientexception", method = RequestMethod.POST)
	public ResponseEntity<ProgramProfileClientException> addProgramProfileClientException(@RequestBody ProgramProfileClientException programProfileClientException, UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();
        ProgramProfileClientException result = programProfileClientExceptionService.addProgramProfileClientException(programProfileClientException);
//        if (flag == false) {
//        	return new ResponseEntity<Void>(headers, HttpStatus.CONFLICT);
//        }

        headers.setLocation(builder.path("/programprofileclientexception/{id}").buildAndExpand(programProfileClientException.getId()).toUri());
        return new ResponseEntity<ProgramProfileClientException>(result, headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/programprofileclientexception/{id}", method = RequestMethod.PUT )
	public ResponseEntity<ProgramProfileClientException> updateProgramProfileClientException(@RequestBody ProgramProfileClientException programProfileClientException) {
		programProfileClientExceptionService.updateProgramProfileClientException(programProfileClientException);
		return new ResponseEntity<ProgramProfileClientException>(programProfileClientException, HttpStatus.OK);
	}
	
	@RequestMapping(value="/programprofileclientexception/{id}", method = RequestMethod.DELETE )
	public ResponseEntity<Void> deleteProgramProfileClientException(@PathVariable("id") Integer id) {
		programProfileClientExceptionService.deleteProgramProfileClientException(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
