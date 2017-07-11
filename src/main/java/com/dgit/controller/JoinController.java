package com.dgit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class JoinController {
	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	
	@RequestMapping(value="join", method=RequestMethod.GET)
	public String getJoin(){
		return "JoinForm";
	}
	
	@RequestMapping(value="join", method=RequestMethod.POST)
	public String postJoin(@ModelAttribute("name") String name,
			@ModelAttribute("password") String password){
		return "JoinResult";
	}
}
