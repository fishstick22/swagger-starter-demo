package org.dnsalias.muppets.poc.swagger.starterdemo.repository;

import org.dnsalias.muppets.poc.swagger.starterdemo.entity.Program;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProgramRepository extends JpaRepository<Program, Integer>{

	@Query("SELECT CASE WHEN COUNT(p) > 0 THEN 'true' ELSE 'false' END FROM Program p WHERE p.name = ?1")
	boolean existsByName(String name);

}
