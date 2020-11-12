package com.cardif.teste.service;

import org.springframework.stereotype.Service;

import com.cardif.teste.arquitetura.service.GenericServiceimpl;
import com.cardif.teste.model.entity.Funcionario;
import com.cardif.teste.repository.FuncionarioRepository;

@Service
public class FuncionarioService extends GenericServiceimpl<FuncionarioRepository, Funcionario>{

}
