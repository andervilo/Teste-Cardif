package com.cardif.teste.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cardif.teste.model.entity.Cargo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/cargos")
@Api(tags = "Cargos")
public class CargoController {

	@GetMapping("/")
	@ApiOperation(value = "Obter Cargos.")
	public ResponseEntity<?> listAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Obter Cargo por ID.")
	public ResponseEntity<?> showById(@PathVariable Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@PostMapping(value="/")
	@ApiOperation(value = "Criar novo Cargo.")
	public ResponseEntity<?> create(Cargo object, BindingResult result) {
		// TODO Auto-generated method stub
		return null;
	}

	@PutMapping(value="/{id}")
	@ApiOperation(value = "Atualizar Cargo por ID.")
	public ResponseEntity<?> update(@PathVariable Long id, Cargo object, Errors errors) {
		// TODO Auto-generated method stub
		return null;
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Excluir Cargo por ID.")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
