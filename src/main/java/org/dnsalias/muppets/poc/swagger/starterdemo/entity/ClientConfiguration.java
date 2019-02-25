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

@Entity
//@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id", scope = ProgramConfiguration.class)
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
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
	@ManyToOne
	@JoinColumn(name="communication_id", nullable=false)
	@JsonIdentityReference(alwaysAsId = true)
	private Communication communication;	// DB FK

	public Communication getCommunication() {
		return communication;
	}
	public void setCommunication(Communication communication) {
		this.communication = communication;
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
	public int getChanEmailPriority() {
		return chanEmailPriority;
	}
	public void setChanEmailPriority(int chanEmailPriority) {
		this.chanEmailPriority = chanEmailPriority;
	}
	public int getChanIvrPriority() {
		return chanIvrPriority;
	}
	public void setChanIvrPriority(int chanIvrPriority) {
		this.chanIvrPriority = chanIvrPriority;
	}
	public int getChanSmsPriority() {
		return chanSmsPriority;
	}
	public void setChanSmsPriority(int chanSmsPriority) {
		this.chanSmsPriority = chanSmsPriority;
	}
	public int getChanSecurePriority() {
		return chanSecurePriority;
	}
	public void setChanSecurePriority(int chanSecurePriority) {
		this.chanSecurePriority = chanSecurePriority;
	}
	public int getChanMailPriority() {
		return chanMailPriority;
	}
	public void setChanMailPriority(int chanMailPriority) {
		this.chanMailPriority = chanMailPriority;
	}
	public int getChanMobilePriority() {
		return chanMobilePriority;
	}
	public void setChanMobilePriority(int chanMobilePriority) {
		this.chanMobilePriority = chanMobilePriority;
	}
	public String getChanDefault() {
		return chanDefault;
	}
	public void setChanDefault(String chanDefault) {
		this.chanDefault = chanDefault;
	}
	public char getRequired() {
		return required;
	}
	public void setRequired(char required) {
		this.required = required;
	}
	public char getMandatory() {
		return mandatory;
	}
	public void setMandatory(char mandatory) {
		this.mandatory = mandatory;
	}
	public Date getEffective() {
		return effective;
	}
	public void setEffective(Date effective) {
		this.effective = effective;
	}
	public Date getExpiration() {
		return expiration;
	}
	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}

}
