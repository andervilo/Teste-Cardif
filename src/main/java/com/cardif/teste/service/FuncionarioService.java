package com.cardif.teste.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cardif.teste.arquitetura.service.GenericServiceimpl;
import com.cardif.teste.model.entity.Departamento;
import com.cardif.teste.model.entity.Funcionario;
import com.cardif.teste.repository.FuncionarioRepository;

@Service
public class FuncionarioService extends GenericServiceimpl<Funcionario, FuncionarioRepository>{
	
	public List<Departamento> getDepartamentosOfFuncionarioById(Long id){
		return getRepository().findById(id).get().getDepartamentos();
	}

}
