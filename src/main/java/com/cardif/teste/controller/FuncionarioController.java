package com.cardif.teste.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cardif.teste.model.dto.FuncionarioInputDTO;
import com.cardif.teste.model.dto.FuncionarioOutputDTO;
import com.cardif.teste.model.entity.Departamento;
import com.cardif.teste.model.entity.Funcionario;
import com.cardif.teste.service.DepartamentoService;
import com.cardif.teste.service.FuncionarioService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/funcionarios")
@Api(tags = "Funcionários")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@Autowired
	private DepartamentoService departamentoService;
	
	private ModelMapper mapper = new ModelMapper();

	@GetMapping("/")
	@ApiOperation(value = "Obter lista.")
	public ResponseEntity<Page<FuncionarioOutputDTO>> listAll(Pageable pageable) {
		Page<FuncionarioOutputDTO> entities = funcionarioService.findAll(pageable)
				 .map((funcionario -> mapper.map(funcionario, FuncionarioOutputDTO.class)));
		
		return ResponseEntity.ok(entities);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Obter por ID.")
	public ResponseEntity<FuncionarioOutputDTO> showById(@PathVariable Long id) {
		if(!funcionarioService.getRepository().existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Funcionário não encontrado!");
		}
		
		Funcionario  funcionario = funcionarioService.findById(id);
		
		FuncionarioOutputDTO funcionarioOutputDTO = mapper.map(funcionario, FuncionarioOutputDTO.class);
		
		return ResponseEntity.ok(funcionarioOutputDTO);
	}

	@PostMapping(value="/")
	@ApiOperation(value = "Criar.", response = FuncionarioOutputDTO.class)
	public ResponseEntity<FuncionarioOutputDTO> create(@Valid @RequestBody FuncionarioInputDTO funcionarioInputDTO) {
		Funcionario funcionario = mapper.map(funcionarioInputDTO, Funcionario.class);
		
		try {
			funcionario = funcionarioService.create(funcionario);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
		
		FuncionarioOutputDTO funcionarioOutputDTO = mapper.map(funcionario, FuncionarioOutputDTO.class);
		
		return ResponseEntity.ok(funcionarioOutputDTO);
	}

	@PutMapping(value="/{id}")
	@ApiOperation(value = "Alterar.")
	public ResponseEntity<FuncionarioOutputDTO> update(@PathVariable Long id, @RequestBody FuncionarioInputDTO funcionarioInputDTO) {
		if(!funcionarioService.getRepository().existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Funcionário não encontrado!");
		}
		
		Funcionario funcionarioToUpdate = funcionarioService.findById(id);
		
		Funcionario funcionario = mapper.map(funcionarioInputDTO, Funcionario.class);
		
		funcionario.setId(funcionarioToUpdate.getId());
		
		funcionario.getDepartamentos().addAll(funcionarioToUpdate.getDepartamentos());
		
		try {
			funcionario = funcionarioService.update(id, funcionario);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
		
		FuncionarioOutputDTO funcionarioOutputDTO = mapper.map(funcionario, FuncionarioOutputDTO.class);
		
		return ResponseEntity.ok(funcionarioOutputDTO);
	
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Excluir.")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		if(!funcionarioService.getRepository().existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Funcionário não encontrado!");
		}
		
		try {
			funcionarioService.delete(id);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}		
		
		return ResponseEntity.ok((new HashMap<String, String>()).put("message", "Funcionário excuido!") );
	}
	
	@GetMapping("/{id}/historico/depatamentos")
	@ApiOperation(value = "Obter histórico de Departamentos do Funcionário por ID.")
	public ResponseEntity<?> getHistoricoDepartamentos(@PathVariable Long id) {
		if(!funcionarioService.getRepository().existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Funcionário não encontrado!");
		}
		return ResponseEntity.ok(funcionarioService.getDepartamentosOfFuncionarioById(id));
	}
	
	@PutMapping("/{idFunc}/alterar/depatamento/{idDept}")
	@ApiOperation(value = "Alterar departamento atual do funcionário.")
	public ResponseEntity<FuncionarioOutputDTO> getAlterarDepartamento(@PathVariable Long idFunc, @PathVariable Long idDept) {
		if(!funcionarioService.getRepository().existsById(idFunc)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Funcionário não encontrado!");
		}
		if(!departamentoService.getRepository().existsById(idDept)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Departamento não encontrado!");
		}
		
		Funcionario funcionario = funcionarioService.findById(idFunc);
		
		Departamento departamento = departamentoService.findById(idDept);
		
		funcionario.setDepartamento(departamento);
		
		funcionarioService.update(idFunc, funcionario);
		
		return ResponseEntity.ok(mapper.map(funcionario, FuncionarioOutputDTO.class));
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}
