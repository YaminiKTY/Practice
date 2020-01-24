package com.tyss.practice.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.tyss.practice.dto.PracticeTable;
@Repository
public class PracticeDaoImpl implements PracticeDao {
	
	@PersistenceUnit
	private EntityManagerFactory emf;
	
	
	
	@Override
	public PracticeTable adduser(PracticeTable practice) {
		EntityManager manager=emf.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(practice);
			transaction.commit();
			return practice;
		}catch(Exception e) {
			manager.close();
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public boolean updateuser(PracticeTable practice) {
		EntityManager manager=emf.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		PracticeTable user=	manager.find(PracticeTable.class,practice.getId());
		
		if(user != null) {
			transaction.begin();
			user.setId(practice.getId());
			user.setUsername(practice.getUsername());
			user.setEmail(practice.getEmail());
			user.setPassword(practice.getPassword());
			user.setNumber(practice.getNumber());
			transaction.commit();
			return true;
		}
		return false;
	}

	@Override
	public List<PracticeTable> getuser() {
		EntityManager manager=emf.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		String jpql="from PracticeTable";
		Query query=manager.createQuery(jpql);
		List<PracticeTable> list = query.getResultList();
		if(list == null) {
			return null;
		}
		return list;
	}

	@Override
	public boolean deleteuser(PracticeTable practice) {
		EntityManager manager=emf.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		PracticeTable user=manager.find(PracticeTable.class,practice.getId());
		try {
			transaction.begin();
			manager.remove(user);
			transaction.commit();
			return true;
		}catch(Exception e) {
			manager.close();
			transaction.rollback();
			e.printStackTrace();
			return false;
		}

		
	}

}
