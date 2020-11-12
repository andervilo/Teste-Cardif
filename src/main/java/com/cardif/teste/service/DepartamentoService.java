package com.cardif.teste.service;

import org.springframework.stereotype.Service;

import com.cardif.teste.arquitetura.service.GenericServiceimpl;
import com.cardif.teste.model.entity.Departamento;
import com.cardif.teste.repository.DepartamentoRepository;

@Service
public class DepartamentoService extends GenericServiceimpl<DepartamentoRepository, Departamento>{

}
