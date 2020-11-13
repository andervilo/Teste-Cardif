package com.cardif.teste.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cardif.teste.model.dto.FuncionarioInputDTO;
import com.cardif.teste.model.entity.Funcionario;
import com.cardif.teste.service.FuncionarioService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/funcionarios")
@Api(tags = "Funcionários")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	private ModelMapper mapper = new ModelMapper();

	@GetMapping("/")
	@ApiOperation(value = "Obter Funcionários.")
	public ResponseEntity<?> listAll(Pageable pageable) {
		return ResponseEntity.ok(funcionarioService.findAll(pageable));
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Obter Funcionário por ID.")
	public ResponseEntity<Funcionario> showById(@PathVariable Long id) {
		if(!funcionarioService.getRepository().existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Funcionário não encontrado!");
		}
		
		return ResponseEntity.ok(funcionarioService.findById(id));
	}

	@PostMapping(value="/")
	@ApiOperation(value = "Criar novo Funcionário.")
	public ResponseEntity<Funcionario> create(@RequestBody FuncionarioInputDTO funcionarioInputDTO, BindingResult result) {
		Funcionario funcionario = mapper.map(funcionarioInputDTO, Funcionario.class);
		try {
			funcionario = funcionarioService.create(funcionario);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
		
		return ResponseEntity.ok(funcionario);
	}

	@PutMapping(value="/{id}")
	@ApiOperation(value = "Atualizar Funcionário por ID.")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody FuncionarioInputDTO funcionarioInputDTO, Errors errors) {
		if(!funcionarioService.getRepository().existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Funcionário não encontrado!");
		}
		
		Funcionario funcionarioToUpdate = funcionarioService.findById(id);
		
		Funcionario funcionario = mapper.map(funcionarioInputDTO, Funcionario.class);
		
		funcionario.setId(funcionarioToUpdate.getId());
		
		try {
			funcionario = funcionarioService.update(id, funcionario);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
		
		return ResponseEntity.ok(funcionario);
	
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Excluir Funcionário por ID.")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@GetMapping("/{id}/historico/depatamentos")
	@ApiOperation(value = "Obter histórico de Departamentos do Funcionário por ID.")
	public ResponseEntity<?> getHistoricoDepartamentos(@PathVariable Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
