package com.dgit.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dgit.domain.ProductVO;

@Controller
public class SampleController2 {
	private static final Logger logger = LoggerFactory.getLogger(SampleController2.class);
	
	@RequestMapping(value="doP", method=RequestMethod.GET)
	public String doProduct(Model model){
		ProductVO p = new ProductVO("김두환", 10000);
		model.addAttribute("item",p);
		return "productDetail";
	}
	
	@RequestMapping(value="doPList", method=RequestMethod.GET)
	public String doProductList(Model model){
		ArrayList<ProductVO> list = new ArrayList<>();
		
		ProductVO p1 = new ProductVO("김두환", 10000);
		list.add(p1);
		
		ProductVO p2 = new ProductVO("김성환", 5000);
		list.add(p2);
		
		ProductVO p3 = new ProductVO("이승우", 500);
		list.add(p3);
		
		model.addAttribute("list",list);
		
		return "productList";
	}
	
	@RequestMapping(value="ajax", method=RequestMethod.GET)
	public String testAjax(){
		return "ajax_test";
	}
}
