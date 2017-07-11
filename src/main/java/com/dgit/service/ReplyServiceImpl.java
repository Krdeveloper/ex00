package com.dgit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dgit.domain.Criteria;
import com.dgit.domain.ReplyVO;
import com.dgit.persistence.ReplyDAO;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Autowired
	ReplyDAO dao;
	
	@Override
	public void addReply(ReplyVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.create(vo);
	}

	@Override
	public List<ReplyVO> listReply(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		return dao.list(bno);
	}

	@Override
	public void modifyReply(ReplyVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.update(vo);
	}

	@Override
	public void removeReply(Integer rno) throws Exception {
		// TODO Auto-generated method stub
		dao.delete(rno);
	}

	@Override
	public List<ReplyVO> listPage(int bno, Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(bno);
		System.out.println(cri);
		return dao.listPage(bno, cri);
	}

	@Override
	public int count(int bno) throws Exception {
		// TODO Auto-generated method stub
		return dao.count(bno);
	}

}
