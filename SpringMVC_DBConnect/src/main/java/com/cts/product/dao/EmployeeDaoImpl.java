package com.cts.product.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.internal.SessionFactoryRegistry;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cts.product.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private SessionFactory sf;
	
	@Override
	public void saveEmployee(Employee emp) {
		sf.getCurrentSession().save(emp);
		System.out.println("Saved");
	}
	
	public List<Employee> findAll(){
		Query<Employee> qry=sf.getCurrentSession().createQuery("from Employee");
		
		return  qry.getResultList();
	}
}
