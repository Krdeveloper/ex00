package com.dgit.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dgit.domain.MemberVO;
import com.dgit.domain.ReplyVO;
import com.dgit.persistence.MemberDAO;
import com.dgit.persistence.ReplyDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class ReplyDAOTest {
	
	@Autowired
	private ReplyDAO dao;
	
	
	
	/*@Test
	public void testInsertMember() throws Exception{
		ReplyVO vo = new ReplyVO();
		vo.setBno(502);
		vo.setReplytext("texttest");
		vo.setReplyer("replyertest");
		dao.create(vo);
	}*/
	@Test
	public void testSelectByNo() throws Exception{
		System.out.println(dao.list(502));
	}
	
	
	/*@Test
	public void testUpdate() throws Exception{
		ReplyVO vo = new ReplyVO();
		vo.setRno(1);
		vo.setReplytext("updatetext");
		dao.update(vo);
	}*/
	@Test
	public void testDelete() throws Exception{
		dao.delete(1);
	}
}
