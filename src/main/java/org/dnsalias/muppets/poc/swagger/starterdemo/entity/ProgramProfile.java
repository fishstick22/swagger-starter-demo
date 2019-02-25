package org.dnsalias.muppets.poc.swagger.starterdemo.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(
		generator=ObjectIdGenerators.PropertyGenerator.class, 
		property="id",
		resolver = EntityIdResolver.class,
		scope = ProgramProfile.class)
public class ProgramProfile implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7716006382991852848L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private char defaultOptIn; // Y/N
	private char visibleInUi; // Y/N/P(romote)
	private char chanEmail; // Y/N
	private char chanIvr; // Y/N
	private char chanSms; // Y/N
	private char chanSecure; // Y/N
	private char chanMail; // Y/N
	private char chanMobile; // Y/N
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date effective;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date expiration;
	
	@ManyToOne
	@JoinColumn(name="program_id", nullable=false)
	@JsonIdentityReference(alwaysAsId = true)
	private Program program;	// DB FK

	public Program getProgram() {
		return program;
	}
	public void setProgram(Program program) {
		this.program = program;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public char getDefaultOptIn() {
		return defaultOptIn;
	}
	public void setDefaultOptIn(char defaultOptIn) {
		this.defaultOptIn = defaultOptIn;
	}
	public char getVisibleInUi() {
		return visibleInUi;
	}
	public void setVisibleInUi(char visibleInUi) {
		this.visibleInUi = visibleInUi;
	}
	public char getChanEmail() {
		return chanEmail;
	}
	public void setChanEmail(char chanEmail) {
		this.chanEmail = chanEmail;
	}
	public char getChanIvr() {
		return chanIvr;
	}
	public void setChanIvr(char chanIvr) {
		this.chanIvr = chanIvr;
	}
	public char getChanSms() {
		return chanSms;
	}
	public void setChanSms(char chanSms) {
		this.chanSms = chanSms;
	}
	public char getChanSecure() {
		return chanSecure;
	}
	public void setChanSecure(char chanSecure) {
		this.chanSecure = chanSecure;
	}
	public char getChanMail() {
		return chanMail;
	}
	public void setChanMail(char chanMail) {
		this.chanMail = chanMail;
	}
	public char getChanMobile() {
		return chanMobile;
	}
	public void setChanMobile(char chanMobile) {
		this.chanMobile = chanMobile;
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
