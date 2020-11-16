package com.cardif.teste.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cardif.teste.arquitetura.service.GenericServiceimpl;
import com.cardif.teste.model.entity.Departamento;
import com.cardif.teste.model.entity.Funcionario;
import com.cardif.teste.repository.FuncionarioRepository;

@Service
public class FuncionarioService extends GenericServiceimpl<Funcionario, FuncionarioRepository>{
	
	@Autowired
	private FuncionarioRepository repository;
	
	public List<Departamento> getDepartamentosOfFuncionarioById(Long id){
		return repository.findById(id).get().getDepartamentos();
	}
	
	public List<Funcionario> getFuncionariosByDepartamento(Departamento departamento){
		return repository.findByDepartamento(departamento);
	}

}
