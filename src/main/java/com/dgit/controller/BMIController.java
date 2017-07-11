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

@Controller
public class BMIController {
	private static final Logger logger = LoggerFactory.getLogger(BMIController.class);
	
	@RequestMapping(value="bmi", method=RequestMethod.GET)
	public String getBMI(){
		return "bmiForm";
	}
	
	@RequestMapping(value="bmi", method=RequestMethod.POST)
	public String postBMI(MyInfo info, Model model){
		info.setBmiCalculator(new BMICalculator());
		
		model.addAttribute("myInfo", info);
		return "bmiResult";
	}
}
