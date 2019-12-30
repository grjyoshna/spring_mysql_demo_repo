package com.spring.mysql1.api.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.mysql1.api.model.Person;

public interface PersonDao extends JpaRepository<Person, Integer>{

	//void updateById(Person per);
	
	@Query(value="select P from Person P")
	List<Person> getAllPersons();
	@Query(value="select * from person p", nativeQuery=true)
	List<Person> getPersonsByNative();

	//Person findByName(String firstName);

}
