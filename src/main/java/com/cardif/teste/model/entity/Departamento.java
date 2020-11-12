package com.cardif.teste.model.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import com.cardif.teste.arquitetura.entity.BaseEntity;

@Entity
public class Departamento extends BaseEntity {

	private static final long serialVersionUID = -4186838054769565177L;

	@Column(name = "departamento_name")
	private String nomeDepartamento;
	
	@ManyToMany(mappedBy = "departamentos")
	private Set<Funcionario> funcionarios;

	public Departamento() {

	}

	public String getNomeDepartamento() {
		return nomeDepartamento;
	}

	public void setNomeDepartamento(String nomeDepartamento) {
		this.nomeDepartamento = nomeDepartamento;
	}

	public Set<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(Set<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
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
