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

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @NoArgsConstructor @ToString(exclude = {"programConfiguration", "clientConfiguration"})
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
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy="communication")
	@JsonIdentityReference(alwaysAsId = true)
	private Set<ClientConfiguration> clientConfiguration;
	
}
