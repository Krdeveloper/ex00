package com.dgit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dgit.domain.BMICalculator;
import com.dgit.domain.MyInfo;
import com.dgit.domain.Report;
import com.dgit.domain.StudentInfo;

@Controller
public class StudentController {
	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
	
	@RequestMapping(value="student", method=RequestMethod.GET)
	public String getStudent(){
		return "studentForm";
	}
	
	@RequestMapping(value="student", method=RequestMethod.POST)
	public String postStudent(StudentInfo info, Model model){
		info.setReport(new Report());
		
		model.addAttribute("studentInfo", info);
		return "studentResult";
	}
}
