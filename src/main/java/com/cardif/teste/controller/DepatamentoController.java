package com.cardif.teste.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cardif.teste.arquitetura.controller.AbstractRestController;
import com.cardif.teste.model.dto.DepartamentoOutputDTO;
import com.cardif.teste.model.dto.FuncionarioOutputDTO;
import com.cardif.teste.model.entity.Departamento;
import com.cardif.teste.service.DepartamentoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/departamentos")
@Api(tags = "Departamentos")
public class DepatamentoController extends AbstractRestController<Departamento, DepartamentoService> {

	@GetMapping("/")
	@ApiOperation(value = "Obter Lista.")
	@Override
	public ResponseEntity<Page<DepartamentoOutputDTO>> listAll(Pageable pageable) {
		return ResponseEntity.ok(this.getService().findAll(pageable));
	}

	@Override
	@GetMapping("/{id}")
	@ApiOperation(value = "Obter por ID.")
	public ResponseEntity<DepartamentoOutputDTO> showById(@PathVariable Long id) {
		return ResponseEntity.ok(getService().findByIdDTO(id));
	}

	@PutMapping("/{idDept}/chefe/definir/{idFunc}")
	@ApiOperation(value = "Definir chefe do Departamento.")
	public ResponseEntity<DepartamentoOutputDTO> setChefe(@PathVariable Long idDept, @PathVariable Long idFunc) {
		return ResponseEntity.ok(getService().setChefe(idDept, idFunc));
	}

	@GetMapping("/{id}/chefe/obter")
	@ApiOperation(value = "Obter chefe do Departamento.")
	public ResponseEntity<FuncionarioOutputDTO> getChefe(@PathVariable Long id) {
		return ResponseEntity.ok(getService().getChefe(id));
	}
	
	@PutMapping("/{id}/chefe/remover")
	@ApiOperation(value = "Remover chefe do Departamento.")
	public ResponseEntity<DepartamentoOutputDTO> removeChefe(@PathVariable Long id) {
		return ResponseEntity.ok(getService().removeChefe(id));
	}

	@GetMapping("/{id}/funcionarios")
	@ApiOperation(value = "Obter Funcionários do Departamento.")
	public ResponseEntity<List<FuncionarioOutputDTO>> getFuncionarios(@PathVariable Long id) {
		return ResponseEntity.ok(getService().getFuncionarios(id));
	}
}
