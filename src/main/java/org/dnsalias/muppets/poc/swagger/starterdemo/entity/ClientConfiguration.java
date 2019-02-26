package org.dnsalias.muppets.poc.swagger.starterdemo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @NoArgsConstructor @ToString(exclude = {"client", "communication"})
@JsonIdentityInfo(
		generator=ObjectIdGenerators.PropertyGenerator.class, 
		property="id",
		resolver = EntityIdResolver.class,
		scope = ClientConfiguration.class)
public class ClientConfiguration implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -835236450268090523L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	private int chanEmailPriority;
	private int chanIvrPriority;
	private int chanSmsPriority;
	private int chanSecurePriority;
	private int chanMailPriority;
	private int chanMobilePriority;
	private String chanDefault;
	private char required;
	private char mandatory;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date effective;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date expiration;	
	
	@ManyToOne
	@JoinColumn(name="client_id", nullable=false)
	@JsonIdentityReference(alwaysAsId = true)
	private Client client;	// DB FK
	
	@ManyToOne
	@JoinColumn(name="communication_id", nullable=false)
	@JsonIdentityReference(alwaysAsId = true)
	private Communication communication;	// DB FK

}
