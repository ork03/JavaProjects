package com.techstudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techstudy.entity.TechStudyEntity;



@Repository
public interface TechStudyRepository extends JpaRepository<TechStudyEntity, Integer>{
	TechStudyEntity findBycourseName(String course);
	
}
