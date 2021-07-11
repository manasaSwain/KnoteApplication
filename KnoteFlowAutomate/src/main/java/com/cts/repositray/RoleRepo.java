package com.cts.repositray;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cts.model.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long>{
	
	@Query("SELECT r  FROM Role r where r.name=?1")
	public Role findRoleByName(String theRoleName);

}
