package com.dgit.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dgit.domain.MemberVO;
import com.dgit.persistence.MemberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class MemberDAOTest {
	
	@Autowired
	private MemberDAO dao;
	
	/*@Test
	public void testTime() throws Exception{
		System.out.println(dao.readTime());
	}*/
	
	/*@Test
	public void testInsertMember() throws Exception{
		MemberVO vo = new MemberVO();
		vo.setUserid("userid");
		vo.setEmail("user00@aaa.com");
		vo.setUserpw("userpw");
		vo.setUsername("username");
		dao.createMember(vo);
	}*/
	/*@Test
	public void testSelectById() throws Exception{
		System.out.println(dao.readMember("userid"));
	}*/
	/*@Test
	public void testSelectByIdPw() throws Exception{
		System.out.println(dao.readWithPW("userid", "userpw"));
	}*/
	/*@Test
	public void tesetSelectAll() {
		System.out.println(dao.selectAll());
	}
	@Test
	public void testUpdate(){
		MemberVO mem = new MemberVO();
		mem.setUserid("testid");
		mem.setUserpw("pppppppp");
		mem.setUsername("nnnnnn");
		mem.setEmail("eeeee");
		dao.updateMember(mem);
	}*/
	@Test
	public void testDelete(){
		dao.deleteMember("userid");
	}
}
