package com.cardif.teste.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cardif.teste.arquitetura.controller.AbstractRestController;
import com.cardif.teste.model.dto.DepartamentoOutputDTO;
import com.cardif.teste.model.dto.FuncionarioOutputDTO;
import com.cardif.teste.model.entity.Departamento;
import com.cardif.teste.model.entity.Funcionario;
import com.cardif.teste.service.DepartamentoService;
import com.cardif.teste.service.FuncionarioService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/departamentos")
@Api(tags = "Departamentos")
public class DepatamentoController extends AbstractRestController<Departamento, DepartamentoService>{
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@Autowired
	private DepartamentoService departamentoService;
	
	private ModelMapper mapper = new ModelMapper();
	
	@GetMapping("/")
	@ApiOperation(value = "Obter Lista.")
	@Override
	public ResponseEntity<Page<DepartamentoOutputDTO>> listAll(Pageable pageable) {
		Page<Departamento> depPage = (Page<Departamento>) super.listAll(pageable).getBody();
		Page<DepartamentoOutputDTO> page = (Page<DepartamentoOutputDTO>) depPage.map(
				(departamento -> mapper.map(departamento, DepartamentoOutputDTO.class))
				);
		return ResponseEntity.ok(page);
	}
	
	@Override
	@GetMapping("/{id}")
	@ApiOperation(value = "Obter por ID.")
	public ResponseEntity<DepartamentoOutputDTO> showById(@PathVariable Long id) {
		Departamento departamento = (Departamento) super.showById(id).getBody();
		return ResponseEntity.ok(mapper.map(departamento, DepartamentoOutputDTO.class));
	}
	
	@PutMapping("/{idDept}/definir/chefe/{idFunc}")
	@ApiOperation(value = "Definir chefe do Departamento.")
	public ResponseEntity<DepartamentoOutputDTO> setChefe(@PathVariable Long idDept, @PathVariable Long idFunc){
		if(!funcionarioService.getRepository().existsById(idFunc)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Funcionário não encontrado!");
		}
		if(!departamentoService.getRepository().existsById(idDept)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Departamento não encontrado!");
		}
		
		Funcionario funcionario = funcionarioService.findById(idFunc);
		
		Departamento departamento = departamentoService.findById(idDept);
		
		departamento.setChefe(funcionario);
		
		departamentoService.update(idDept, departamento);
		
		return ResponseEntity.ok(mapper.map(departamento, DepartamentoOutputDTO.class));
	}
	
	@GetMapping("/{id}/chefe")
	@ApiOperation(value = "Obter chefe do Departamento.")
	public ResponseEntity<FuncionarioOutputDTO> getChefe(@PathVariable Long id){
		if(!departamentoService.getRepository().existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Departamento não encontrado!");
		}
		
		Departamento departamento = departamentoService.findById(id);
		
		return ResponseEntity.ok(mapper.map(departamento.getChefe(), FuncionarioOutputDTO.class));
	}
}
