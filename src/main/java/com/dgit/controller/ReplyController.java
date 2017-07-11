package com.dgit.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dgit.domain.Criteria;
import com.dgit.domain.MemberVO;
import com.dgit.domain.PageMaker;
import com.dgit.domain.ReplyVO;
import com.dgit.service.MemberService;
import com.dgit.service.ReplyService;

@RestController
@RequestMapping("/replies")
public class ReplyController {
	private static final Logger logger = LoggerFactory.getLogger(ReplyController.class);
	
	@Autowired
	private ReplyService service;
	
	@Autowired
	private MemberService memService;
	
	//controller/replies
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<String> register(@RequestBody ReplyVO vo){
		ResponseEntity<String> entity = null;
		logger.info("replies ADD POSt");
		logger.info(vo.toString());
		try{
			service.addReply(vo);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
			entity = new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value="/all/{bno}", method=RequestMethod.GET)
	public ResponseEntity<List<ReplyVO>> list(@PathVariable("bno") Integer bno){
		ResponseEntity<List<ReplyVO>> entity = null;
		
		try{
			List<ReplyVO> list = service.listReply(bno);
			entity = new ResponseEntity<List<ReplyVO>>(list, HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();			
			entity = new ResponseEntity<List<ReplyVO>>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	@RequestMapping(value="/{rno}", method=RequestMethod.PUT)
	public ResponseEntity<String> update(@PathVariable("rno") Integer rno, @RequestBody ReplyVO vo){
		ResponseEntity<String> entity = null;
		logger.info("put modify");
		logger.info(rno + " , " + vo.toString());
		try{
			vo.setRno(rno);
			service.modifyReply(vo);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
			entity = new ResponseEntity<>("fail", HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value="/{rno}", method=RequestMethod.DELETE)
	public ResponseEntity<String> remove(@PathVariable("rno") Integer rno){
		ResponseEntity<String> entity = null;
		
		try{
			service.removeReply(rno);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}catch(Exception e){
			entity = new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	//연습
	@RequestMapping(value="/mem/{userid}", method=RequestMethod.GET)
	public ResponseEntity<MemberVO> mem(@PathVariable("userid") String userid){
		ResponseEntity<MemberVO> entity = null;
		System.out.println("================================================");
		System.out.println(userid);
		try{
			MemberVO mem = memService.member(userid);
			System.out.println(mem);
			System.out.println(userid);
			entity = new ResponseEntity<MemberVO>(mem, HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();			
			entity = new ResponseEntity<MemberVO>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	@RequestMapping(value="/{bno}/{page}", method=RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> listPage(@PathVariable("bno") Integer bno,
													@PathVariable("page") Integer page){
		ResponseEntity<Map<String, Object>> entity = null;
		
		logger.info("------------List page GET");
		
		try{
			Criteria cri = new Criteria();
			cri.setPage(page);
			List<ReplyVO> list = service.listPage(bno, cri);
			System.out.println(list);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(service.count(bno));
			
			Map<String, Object> map = new HashMap<>();
			map.put("list", list);
			map.put("pageMaker", pageMaker);
			
			entity = new ResponseEntity<>(map, HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
			
			entity = new ResponseEntity<Map<String, Object>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}
