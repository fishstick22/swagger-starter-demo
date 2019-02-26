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
@Getter @Setter @NoArgsConstructor @ToString(exclude = {"programProfileClientException", "clientConfiguration"})
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
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy="client")
	@JsonIdentityReference(alwaysAsId = true)
	private Set<ClientConfiguration> clientConfiguration;
	
}
