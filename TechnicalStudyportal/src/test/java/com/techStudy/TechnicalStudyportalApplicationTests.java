package com.techStudy;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.techstudy.entity.TechStudyEntity;
import com.techstudy.repository.TechStudyRepository;

@SpringBootTest
@TestMethodOrder(value = OrderAnnotation.class)


class TechnicalStudyportalApplicationTests {
	@Autowired
	private TechStudyRepository tsr;
	@Test
	@Order(1)
	void save() {
		TechStudyEntity tse=new TechStudyEntity("java", "https://docs.oracle.com/javase/tutorial/");
		TechStudyEntity tse1=tsr.save(tse);
		Assertions.assertNotNull(tse1);
	}
	@Test
	@Order(2)
	void update() {
		String course="java";
		
		
		
		TechStudyEntity tse1=tsr.findBycourseName(course);
		//System.out.println(tse1.getCourseName());
		tse1.setCourseName("python");
		tsr.save(tse1);
		assertThat(tse1.getCourseName()).isEqualTo("python");
		
	}
	@Test
	@Order(3)
	void fetchlist() {
		List<TechStudyEntity> li=tsr.findAll();
		for(TechStudyEntity tse:li) {
			System.out.println(tse);
		}
		Assertions.assertNotNull(li);
		assertThat(li).size().isPositive();

	}
	@Test
	@Order(4)
	void findbyname() {
		String course="python";
		TechStudyEntity tse=tsr.findBycourseName(course);
		assertThat(tse.getCourseName()).isEqualTo(course);
	}
	@Test
	@Order(5)
	void delete() {
		int id=1;
		boolean existedbeforedelete=tsr.findById(id).isPresent();
		tsr.deleteById(id);
		boolean notexistedafterdelete=tsr.findById(id).isPresent();
		Assertions.assertTrue(existedbeforedelete);
		Assertions.assertFalse(notexistedafterdelete);

	}
}
