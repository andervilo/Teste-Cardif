package com.cardif.teste.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.cardif.teste.arquitetura.service.GenericServiceimpl;
import com.cardif.teste.model.dto.DepartamentoOutputDTO;
import com.cardif.teste.model.dto.FuncionarioOutputDTO;
import com.cardif.teste.model.entity.Departamento;
import com.cardif.teste.model.entity.Funcionario;
import com.cardif.teste.repository.DepartamentoRepository;

import org.modelmapper.TypeToken;
import java.lang.reflect.Type;

@Service
public class DepartamentoService extends GenericServiceimpl<Departamento, DepartamentoRepository>{
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	private ModelMapper mapper = new ModelMapper();

	@Override
	public Page<DepartamentoOutputDTO> findAll(Pageable pageable) {
		Page<Departamento> depPage = (Page<Departamento>) super.findAll(pageable);
		
		Page<DepartamentoOutputDTO> page = (Page<DepartamentoOutputDTO>) depPage.map(
				(departamento -> mapper.map(departamento, DepartamentoOutputDTO.class))
				);
		return page;
	}
	
	public DepartamentoOutputDTO findByIdDTO(Long id) {
		Departamento departamento = (Departamento) super.findById(id);
		return mapper.map(departamento, DepartamentoOutputDTO.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<FuncionarioOutputDTO> getFuncionarios(Long id){
		if(!getRepository().existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Departamento não encontrado!");
		}
		Departamento departamento = this.findById(id);
		
		List<FuncionarioOutputDTO> listFuncionarios = new ArrayList<FuncionarioOutputDTO>();
		
		Type listType = new TypeToken<List<FuncionarioOutputDTO>>(){}.getType();
		
		listFuncionarios = (List<FuncionarioOutputDTO>) mapper.map(funcionarioService.getFuncionariosByDepartamento(departamento), listType);
			
		return listFuncionarios;
	}
	
	public DepartamentoOutputDTO setChefe(Long idDept, Long idFunc) {
		if(!funcionarioService.getRepository().existsById(idFunc)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Funcionário não encontrado!");
		}
		if(!getRepository().existsById(idDept)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Departamento não encontrado!");
		}
		
		Funcionario funcionario = funcionarioService.findById(idFunc);
		
		Departamento departamento = findById(idDept);
		
		departamento.setChefe(funcionario);
				
		return mapper.map(update(idDept, departamento), DepartamentoOutputDTO.class);
	}
	
	public FuncionarioOutputDTO getChefe(Long id) {
		if(!getRepository().existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Departamento não encontrado!");
		}
		
		Departamento departamento = findById(id);
		if(departamento.getChefe() == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Departamento não possui Chefe definido!");
		}
		return mapper.map(departamento.getChefe(), FuncionarioOutputDTO.class);
	}

	public DepartamentoOutputDTO removeChefe(Long id) {
		if(!getRepository().existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Departamento não encontrado!");
		}
		
		Departamento departamento = findById(id);
		
		if(departamento.getChefe() == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Departamento não possui Chefe definido!");
		}
		
		departamento.setChefe(null);
		
		update(id, departamento);
		
		return mapper.map(departamento, DepartamentoOutputDTO.class);
	}
}
