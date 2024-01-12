package com.techstudy.controller;

import java.util.List;
import java.util.logging.Logger;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.techstudy.controller.dto.UserRegistrationDto;
import com.techstudy.entity.Admin;
import com.techstudy.entity.TechStudyDto;
import com.techstudy.entity.TechStudyEntity;
import com.techstudy.entity.User;

import com.techstudy.service.AdminService;
import com.techstudy.service.TechStudyImpl;
import com.techstudy.service.UserService;


@Controller

public class TechStudyController {
	
	private static final String DETAILS="details";
	private static final String DISPLAYCURDURL="redirect:/cruddetails";
	private static final String DISPLAYSTUDYURL="redirect:/studydetails";
	private static final String ERRORURL="redirect:/loginuser?ans=error";
	
	private String lname = "";
	private String fname = "";

	@Autowired
	private TechStudyImpl ts;

	 static Logger log = Logger.getLogger(TechStudyController.class.getName());
	 @Autowired
	    private UserService userService;
	 @Autowired 
	 private AdminService adminService;
	
	 
	 @RequestMapping("/loginuser")
	 public String loginuser() {
			return "loginuser.jsp";
		}
	
	@RequestMapping("/validatedetails")
	public String validation(@ModelAttribute("userForm") @Validated UserRegistrationDto userForm,
	        BindingResult result,Model m) {
		if(userForm.getEmail()==null) {
			return ERRORURL;
		}
		User email = userService.findByEmail(userForm.getEmail());
		if(email==null) {
			return ERRORURL;
		}
		
		
		String passw=userForm.getPassword();
		
		BCryptPasswordEncoder bpe=new BCryptPasswordEncoder();


		String pass=email.getPassword();
		boolean a=bpe.matches(passw, pass);

		if(pass==null) {
			return ERRORURL;
		}
		if(!a)
			return ERRORURL;
       fname=email.getFirstName();
       lname=email.getLastName();
       return DISPLAYSTUDYURL;
		
	}
	
	
	@RequestMapping("studydetails")
	public String getall(Model m) {
		
		List<TechStudyEntity> li=ts.fetchList();
		m.addAttribute(DETAILS,li);
		String fn = "firstname";
		m.addAttribute(fn, fname.toUpperCase());
		String ln = "lastname";
		m.addAttribute(ln, lname.toUpperCase());
		
		return "Studyportaldetails.jsp";
	}
	@RequestMapping("/")
	public String home() {
		return "index.jsp";
	}
	
	@RequestMapping("admin")
	public String adminlogin() {
		Admin admin;
		admin=adminService.findByUsername("ork03");
		if(admin!=null) {
			return "admin.jsp";
		}
		else {
			adminService.saveadmin();
		}
		return "admin.jsp";

	}
	@RequestMapping("validateAdmin")
	public String validatingAdmin(@RequestParam("username")String uname,@RequestParam("password")String pass ) {
		
		Admin a=adminService.findByUsername(uname);
		if(a==null) {
			return "redirect:/admin?ans=error";
		}
		BCryptPasswordEncoder bpe=new BCryptPasswordEncoder();
		String passw=a.getPassword();
		boolean b=bpe.matches(pass, passw);
		
		if(!a.getUsername().equals(uname) || !b) {
			return "redirect:/admin?ans=error";
		}
	
		return DISPLAYCURDURL;
	}
	
	@PostMapping(value = "/save")
	public ModelAndView save(@ModelAttribute TechStudyDto tsd) {
		
		TechStudyEntity tse=new TechStudyEntity();
		tse.setCourseName(tsd.getCourseName());
		tse.setUrl(tsd.getUrl());
		ts.saveDetails(tse);
		log.info("Details have been saved");
		return new ModelAndView(DISPLAYCURDURL);
	}
	@RequestMapping("/cruddetails")
	public String cruddetails(Model m) {

		List<TechStudyEntity> li=ts.fetchList();
		m.addAttribute(DETAILS, li);
		return "crudoperations.jsp";

	}
	@RequestMapping("/addnew")
	public String addnewrow() {
		log.info("you are adding new details");
		return "addform.jsp";
	}
	@RequestMapping("/deletebyid/{id}")
	public ModelAndView delete(@PathVariable("id") int id) {
		ts.deleteById(id);
		log.info("The details have been deleted");
		return new ModelAndView(DISPLAYCURDURL);
	}
	@RequestMapping("/{id}")
	public String edit(@PathVariable int id,Model m) {
		TechStudyEntity tse=ts.getbyid(id);
		m.addAttribute(DETAILS,tse);
		log.info("you are editing the form");
		return "editform.jsp";
	}
	@PostMapping(value="/updatesave/{id}")
	public String update(@PathVariable int id,@ModelAttribute("techstudy") TechStudyDto tsd,Model m ) {
		
		TechStudyEntity tech=ts.getbyid(id);
		tech.setId(id);
		tech.setCourseName(tsd.getCourseName());
		tech.setUrl(tsd.getUrl());
		ts.saveDetails(tech);
		log.info("Details have updated successfully");
		return DISPLAYCURDURL;
		
	}
}
