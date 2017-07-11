package com.dgit.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dgit.domain.MemberVO;

@RestController
@RequestMapping("/sample")
public class SampleController3 {
	
	@RequestMapping("/hello") //value="/hello" , method = RequestMethod.GET
	public String sayHello(){
		return "Hello world!";
	}
	
	@RequestMapping("/sendVO")
	public MemberVO sendVO(){
		MemberVO vo = new MemberVO();
		vo.setUserid("uuu");
		vo.setEmail("u@gm.com");
		vo.setRegdate(new Date());
		vo.setUpdatedate(new Date());
		vo.setUsername("nnaamm");
		vo.setUserpw("ppww");
		return vo;
		
	}
	@RequestMapping("/sendList")
	public List<MemberVO> sendList(){
		List<MemberVO> list = new ArrayList<>();
		for(int i=0; i<10; i++){
			MemberVO vo = new MemberVO();
			vo.setUserid("uuu");
			vo.setEmail("u@gm.com");
			vo.setRegdate(new Date());
			vo.setUpdatedate(new Date());
			vo.setUsername("nnaamm");
			vo.setUserpw("ppww");
			list.add(vo);
		}		
		return list;		
	}
	
	@RequestMapping("/sendMap")
	public Map<Integer, MemberVO> sendMap(){
		Map<Integer, MemberVO> map = new HashMap<>();
		for(int i=0; i<10; i++){
			MemberVO vo = new MemberVO();
			vo.setUserid("uuu");
			vo.setEmail("u@gm.com");
			vo.setRegdate(new Date());
			vo.setUpdatedate(new Date());
			vo.setUsername("nnaamm");
			vo.setUserpw("ppww");
			map.put(i, vo);
		}	
		return map;
		
	}
	
	@RequestMapping("/sendErrorAuth")
	public ResponseEntity<Void> sendListAuth(){//400error
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);//400error
	}
	@RequestMapping("/sendErrorNot")
	public ResponseEntity<List<MemberVO>> sendListNot(){
		List<MemberVO> list = new ArrayList<>();
		for(int i=0; i<10; i++){
			MemberVO vo = new MemberVO();
			vo.setUserid("uuu");
			vo.setEmail("u@gm.com");
			vo.setRegdate(new Date());
			vo.setUpdatedate(new Date());
			vo.setUsername("nnaamm");
			vo.setUserpw("ppww");
			list.add(vo);
		}		
		return new ResponseEntity<List<MemberVO>>(list, HttpStatus.NOT_FOUND);//404 error
	}
}
