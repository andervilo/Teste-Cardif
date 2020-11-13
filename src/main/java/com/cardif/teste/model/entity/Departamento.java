package com.cardif.teste.model.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import com.cardif.teste.arquitetura.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Departamento extends BaseEntity {

	private static final long serialVersionUID = -4186838054769565177L;

	@Column(name = "departamento_name")
	private String nomeDepartamento;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "departamentos")
	private List<Funcionario> funcionarios = new ArrayList<>();

	public Departamento() {

	}

	public String getNomeDepartamento() {
		return nomeDepartamento;
	}

	public void setNomeDepartamento(String nomeDepartamento) {
		this.nomeDepartamento = nomeDepartamento;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	
	public void addFuncionario(Funcionario funcionario) {
		if(this.funcionarios.contains(funcionario)){
			return;
		}
		this.funcionarios.add(funcionario);
	}
	
	public void deleteFuncionario(Funcionario funcionario) {
		if(!this.funcionarios.contains(funcionario)){
			return;
		}
		this.funcionarios.remove(funcionario);
	}

}
