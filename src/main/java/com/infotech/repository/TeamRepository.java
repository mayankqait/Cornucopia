package com.infotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.infotech.model.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team,Integer> {
    
	public Team findOne(Integer id);
		
	
	@Query(value="select * from team t where t.team_name = :teamName",nativeQuery=true)
	 public static  List<Team> findByName(@Param("teamName") String teamName) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
		
	
}
