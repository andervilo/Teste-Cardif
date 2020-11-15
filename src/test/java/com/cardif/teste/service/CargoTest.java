package com.cardif.teste.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import com.cardif.teste.model.entity.Cargo;

@SpringBootTest
class CargoTest {
	
	@Autowired
	CargoService service;

	@Test
	void obterListaCargoTest() {
		List<Cargo> listCargo = (List<Cargo>) service.findAll(PageRequest.of(0, 1000)).getContent();
		assertTrue(!listCargo.isEmpty());
	}
	
	@Test
	void adicionarCargoTest() {
		
		Cargo cargo = new Cargo();
		cargo.setNomeCargo("Administração");
		
		Cargo cargoInserido = service.create(cargo);
		
		Cargo cargoObtido = service.findById(cargoInserido.getId());
		
		assertEquals(cargo.getNomeCargo(), cargoObtido.getNomeCargo());
	}
	
	@Test
	void alterarCargoTest() {
		
		Cargo cargo = new Cargo();
		cargo.setNomeCargo("RH");
		
		Cargo cargoInserido = service.create(cargo);
		
		Cargo cargoObtido = service.findById(cargoInserido.getId());
		
		cargoObtido.setNomeCargo("Zeladoria");
		
		cargo = service.update(cargoObtido.getId(), cargoObtido);
		
		assertEquals(cargo.getNomeCargo(), cargoObtido.getNomeCargo());
	}
	
	@Test
	void excluirCargoTest() {
		List<Cargo> listCargo = (List<Cargo>) service.findAll(PageRequest.of(0, 1000)).getContent();
		
		service.delete(listCargo.get(0).getId());
		
		List<Cargo> listCargoPosExclusao = (List<Cargo>) service.findAll(PageRequest.of(0, 1000)).getContent();
		
		assertTrue(listCargo.size() > listCargoPosExclusao.size());
	}

}
