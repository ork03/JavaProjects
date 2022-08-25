package com.techstudy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techstudy.entity.TechStudyEntity;
import com.techstudy.repository.TechStudyRepository;
@Service
public class TechStudyImpl implements TechStudyService{
	@Autowired
	private TechStudyRepository tsr;

	@Override
	public List<TechStudyEntity> fetchList() {
		
		return tsr.findAll();
	}

	@Override
	public void saveDetails(TechStudyEntity tse) {
		tsr.save(tse);
		
	}

	@Override
	public void deleteById(int id) {
		tsr.deleteById(id);
		
	}

	@Override
	public TechStudyEntity getbyid(int id) {
		
		return tsr.getById(id);
	}

}
