package com.cardif.teste.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cardif.teste.model.entity.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

}
