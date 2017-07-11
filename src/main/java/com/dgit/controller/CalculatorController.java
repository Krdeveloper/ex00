package com.dgit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CalculatorController {
	private static final Logger logger = LoggerFactory.getLogger(CalculatorController.class);
	
	@RequestMapping(value="calculator", method=RequestMethod.GET)
	public String getCal(){
		return "calculator";
	}
	
	@RequestMapping(value="calculator", method=RequestMethod.POST)
	public String postCal(Model model, @ModelAttribute("num1") double num1,
			@ModelAttribute("num2") double num2){
		
		model.addAttribute("hap", num1+num2);
		return "calResult";
	}
}
