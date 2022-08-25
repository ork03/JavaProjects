package com.techstudy.service;

import java.util.List;
import com.techstudy.entity.TechStudyEntity;

public interface TechStudyService {
	// Read operation
    List<TechStudyEntity> fetchList();
 
    // save and update operation
    void saveDetails(TechStudyEntity tse);
 
    // Delete operation
    void deleteById(int id);
   
    //getting by id
    TechStudyEntity getbyid(int id);
}
