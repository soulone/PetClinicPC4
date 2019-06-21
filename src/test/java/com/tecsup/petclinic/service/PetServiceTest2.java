package com.tecsup.petclinic.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tecsup.petclinic.domain.Pet;
import com.tecsup.petclinic.exception.PetNotFoundException;

import java.util.List;
@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = Replace.NONE) // sirve para conectar a la BD

public class PetServiceTest2 {
private static final Logger logger = LoggerFactory.getLogger(PetServiceTest2.class);
	
	@Autowired
	private PetService petService;
	
	@Test
	public void testFindById1() throws PetNotFoundException {
		
		//Sly
		long id1 = 13;
		Pet p = petService.findById(id1);
		
		Assert.assertEquals("Sly", p.getName());

	}
	
	@Test
	public void testFindById2() throws PetNotFoundException {
		
		//Lucky

		long id2 = 12;
		Pet e = petService.findById(id2);
		
		Assert.assertEquals("Lucky", e.getName());
	}
	
	@Test
	public void testFindByName() {
		
		String name = "Sly";
		int size = 1;
		List<Pet> p = petService.findByName(name);
		
		//p.stream().forEach(p -> logger.info(">>>>>"+p.getId()));
		
		Assert.assertEquals(size, p.size());
		//System.out.print(p);
	}
	
	@Test
	public void testFindByName2() {
		
		String name = "Lucky";
		int size = 2;
		List<Pet> p = petService.findByName(name);		
		
		Assert.assertEquals(size, p.size());
		//System.out.print(p);
	}

}
