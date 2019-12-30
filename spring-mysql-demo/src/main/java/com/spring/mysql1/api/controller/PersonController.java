package com.spring.mysql1.api.controller;

import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mysql1.api.dao.PersonDao;
import com.spring.mysql1.api.model.Person;

@RestController
@RequestMapping("/person")
public class PersonController {
	@Autowired
	private PersonDao dao;
	
	@PostMapping("/postPersons")
	public String postPerson(@RequestBody List<Person> persons)
	{
		dao.saveAll(persons);
		
		return "Total Persons: "+ dao.count();
	}

	@GetMapping("/getPersons")
	public List<Person> getPersons()
	{
		return (List<Person>) dao.findAll();
	}
	
//	@GetMapping("/{firstName}")
//	public Person getPerson(@PathVariable String name)
//	{
//		return dao.findByName(name);
//	}
	
//	@PutMapping("/update")
//	public  void updateByPersonId(@RequestBody Person per)
//	{
////		dao.findById(id).map( (Function<? super Person, ? extends U>) person->{person.setFirstName(per.getFirstName());
////									  person.setLastName(per.getLastName());
////									return (U) dao.save(per);
////									  });
//		
//		dao.updateById(per);
//		
//	}
	
	@DeleteMapping("/deletePerson/{id}")
	public void putPersons( @PathVariable int id)
	{
		dao.deleteById(id);
		
	}
	@DeleteMapping("/deleteAll")
	public String deletePersons()
	{
		dao.deleteAll();
		
		return "Total: "+dao.count();
	}
	
	@GetMapping("/pp")
	public List<Person> getAllPersons()
	{
		return dao.getAllPersons();
	}
	@GetMapping("/pp2")
	public List<Person> getPersonsByNative()
	{
		return dao.getPersonsByNative();
	}
	
}
