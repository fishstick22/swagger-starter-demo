package org.dnsalias.muppets.poc.swagger.starterdemo.repository;

import org.dnsalias.muppets.poc.swagger.starterdemo.entity.ProgramConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProgramConfigurationRepository extends JpaRepository<ProgramConfiguration, Integer>{

	@Query("SELECT CASE WHEN COUNT(pc) > 0 THEN 'true' ELSE 'false' END FROM ProgramConfiguration pc WHERE pc.name = ?1")
	boolean existsByName(String name);

}
