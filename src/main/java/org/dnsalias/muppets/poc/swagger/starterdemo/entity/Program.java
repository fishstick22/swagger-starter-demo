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

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @NoArgsConstructor @ToString
@JsonIdentityInfo(
		generator=ObjectIdGenerators.PropertyGenerator.class, 
		property="id",
		resolver = EntityIdResolver.class,
		scope = Program.class)
public class Program implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1571336590866311408L;

	@Id
	@ApiModelProperty(notes = "The program ID")
	private int id;
	@ApiModelProperty(notes = "The program name")
	private String name;
	@ApiModelProperty(notes = "The program description")
	private String description;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy="program")
	// @JsonIdentityReference(alwaysAsId = true)
	@ApiModelProperty(notes = "The program profile")
	private Set<ProgramProfile> programProfile;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy="program")
	@JsonIdentityReference(alwaysAsId = true)
	@ApiModelProperty(notes = "The program profile client exception(s)")
	private Set<ProgramProfileClientException> programProfileClientException;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy="program")
	@JsonIdentityReference(alwaysAsId = true)
	@ApiModelProperty(notes = "The program configuration")
	private Set<ProgramConfiguration> programConfiguration;

}
