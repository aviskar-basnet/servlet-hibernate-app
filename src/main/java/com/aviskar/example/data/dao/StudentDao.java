package com.aviskar.example.data.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

import com.aviskar.example.data.model.Student;
import com.aviskar.example.util.HibernateUtil;

public class StudentDao {

	public List<Student> findAll() {
		EntityManager em = HibernateUtil.createEntityManager();
		CriteriaQuery<Student> cq = em.getCriteriaBuilder().createQuery(Student.class);
		cq.select(cq.from(Student.class));
		List<Student> students = em.createQuery(cq).getResultList();
		em.close();
		return students;
	}

	public Student save(Student student) {
		EntityManager em = HibernateUtil.createEntityManager();
		em.getTransaction().begin();
		em.persist(student);
		em.getTransaction().commit();
		em.close();
		return student;
	}
}
