package org.dnsalias.muppets.poc.swagger.starterdemo.repository;

import org.dnsalias.muppets.poc.swagger.starterdemo.entity.ProgramProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgramProfileRepository extends JpaRepository<ProgramProfile, Integer> {

}
