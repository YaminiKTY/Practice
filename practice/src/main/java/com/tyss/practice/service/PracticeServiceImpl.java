package com.tyss.practice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.practice.dao.PracticeDao;
import com.tyss.practice.dto.PracticeTable;

@Service
public class PracticeServiceImpl implements PracticeService {
	@Autowired
	private PracticeDao dao;
	@Override
	public PracticeTable adduser(PracticeTable practice) {
		
		return dao.adduser(practice);
	}
	@Override
	public boolean updateuser(PracticeTable practice) {
		
		return dao.updateuser(practice);
	}

	@Override
	public List<PracticeTable> getuser() {
		
		return dao.getuser();
	}

	@Override
	public boolean deleteuser(PracticeTable practice) {
		
		return dao.deleteuser(practice);
	}

	
}
