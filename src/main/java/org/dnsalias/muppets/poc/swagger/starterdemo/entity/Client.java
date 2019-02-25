package org.dnsalias.muppets.poc.swagger.starterdemo.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
//@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id", scope = Program.class)
@JsonIdentityInfo(
		generator=ObjectIdGenerators.PropertyGenerator.class, 
		property="id",
		resolver = EntityIdResolver.class,
		scope = Client.class)
public class Client implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3435002475914858470L;

	@Id
	private int id;
	private String code;
	private String name;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy="client")
	@JsonIdentityReference(alwaysAsId = true)
	private Set<ProgramProfileClientException> programProfileClientException;
	
	public Set<ProgramProfileClientException> getProgramProfileClientException() {
		return programProfileClientException;
	}
	public void setProgramProfileClientException(Set<ProgramProfileClientException> programProfileClientException) {
		this.programProfileClientException = programProfileClientException;
	}
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy="client")
	@JsonIdentityReference(alwaysAsId = true)
	private Set<ClientConfiguration> clientConfiguration;
	
	public Set<ClientConfiguration> getClientConfiguration() {
		return clientConfiguration;
	}
	public void setClientConfiguration(Set<ClientConfiguration> clientConfiguration) {
		this.clientConfiguration = clientConfiguration;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
