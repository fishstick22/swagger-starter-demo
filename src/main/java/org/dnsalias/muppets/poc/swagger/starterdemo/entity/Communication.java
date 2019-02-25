package org.dnsalias.muppets.poc.swagger.starterdemo.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id", scope = Communication.class)
public class Communication implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8425884888221667448L; 

	@Id
	private int id;
	private String name;
	private String description;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy="communication")
	@JsonIdentityReference(alwaysAsId = true)
	private Set<ProgramConfiguration> programConfiguration;

	public Set<ProgramConfiguration> getProgramConfiguration() {
		return programConfiguration;
	}
	public void setProgramConfiguration(Set<ProgramConfiguration> programConfiguration) {
		this.programConfiguration = programConfiguration;
	}
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy="communication")
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
