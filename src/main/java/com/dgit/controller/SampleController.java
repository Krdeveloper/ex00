package com.dgit.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dgit.domain.ProductVO;

@Controller
public class SampleController {
	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	
	@RequestMapping(value = "doA", method=RequestMethod.GET)
	public void doA(){
		logger.info("doA Call -------------");
	}
	
	@RequestMapping(value="doB", method=RequestMethod.GET)
	public String doB(Model model){
		logger.info("doB Call -------------");
		model.addAttribute("result", "doB go");
		return "home";
	}
	
	@RequestMapping(value="doC", method=RequestMethod.GET)
	public String doC(Model model){
		logger.info("doC Call -------------");
		
		model.addAttribute("serverTime", "시시" );
		return "home";
	}
	
	@RequestMapping(value="doD", method=RequestMethod.GET)
	public String doD(Model model, String msg, String key, int aa){
		logger.info("doD Call -------------");
		logger.info("doD msg : " + msg);
		logger.info("doD key : " + key);
		logger.info("doD aa : " + aa);
		model.addAttribute("result", msg);
		
		return "doD";
	}
	
	@RequestMapping(value="doE", method=RequestMethod.GET)
	public String doE(Model model, double d){
		logger.info("doE Call -------------");		
		
		model.addAttribute("result", d);
		
		return "doD";
	}
	
	@RequestMapping(value="doF", method=RequestMethod.GET)
	public String doF(@ModelAttribute("result") String result){
		
		return "doD";
	}
	
	@RequestMapping(value="doG", method=RequestMethod.GET)
	public String doG(){
		
		logger.info("doG Call-----");
		return "redirect:/doC";
	}
	
	@RequestMapping(value="doH", method=RequestMethod.GET)
	public String doH(){
		
		logger.info("doH Call-----");
		return "forward:/doC";
	}
	
	@RequestMapping(value="doJSON", method=RequestMethod.GET)
	public @ResponseBody ProductVO doJSON(){
		logger.info("doJSON Call -----");
		ProductVO vo = new ProductVO("황인영", 30000);
		return vo;
	}
	
}
