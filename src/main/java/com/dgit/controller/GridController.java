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
public class GridController {
	private static final Logger logger = LoggerFactory.getLogger(GridController.class);
	
	@RequestMapping(value="grid1", method=RequestMethod.GET)
	public String getGrid1(){
		return "grid1";
	}
	
	@RequestMapping(value="grid2", method=RequestMethod.GET)
	public String getGrid2(){
		return "grid2";
	}
	
	@RequestMapping(value="modal", method=RequestMethod.GET)
	public String getModal(){
		return "modal";
	}
	
	
}
