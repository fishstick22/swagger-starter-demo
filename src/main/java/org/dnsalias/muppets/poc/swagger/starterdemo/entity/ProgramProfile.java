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
@Getter @Setter @NoArgsConstructor @ToString(exclude = {"program"})
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

}
