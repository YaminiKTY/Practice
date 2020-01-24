package com.tyss.practice.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class PracticeTable {
	@Id
	@GeneratedValue
	@Column
	private int id;
	@Column
	private String username;
	@Column
	private double number;
	@Column
	private String password;
	@Column
	private String email;
}
