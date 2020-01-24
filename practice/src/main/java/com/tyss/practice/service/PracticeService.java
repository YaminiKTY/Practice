package com.tyss.practice.service;

import java.util.List;

import com.tyss.practice.dto.PracticeTable;

public interface PracticeService {

	public PracticeTable adduser(PracticeTable practice);
	public boolean updateuser(PracticeTable practice);
	public List<PracticeTable> getuser();
	public boolean deleteuser(PracticeTable practice);
}
