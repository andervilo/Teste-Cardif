package com.cardif.teste.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cardif.teste.model.entity.Departamento;
import com.cardif.teste.model.entity.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

	List<Funcionario> findByDepartamento(Departamento departamento);
}
