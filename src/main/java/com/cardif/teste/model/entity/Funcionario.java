package com.cardif.teste.model.entity;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.cardif.teste.arquitetura.entity.BaseEntity;
import com.cardif.teste.utils.DateUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Funcionario extends BaseEntity {

	private static final long serialVersionUID = 326579709813911260L;

	@Column(name = "funcionario_name")
	private String nomeFuncionario;

	@Column(name = "funcionario_birthday")
	private LocalDate dataNascFuncionario;

	@Column(name = "funcionario_document")
	private String documentoFuncionario;

	@ManyToOne
	private Cargo cargo;

	@ManyToOne
	private Departamento departamento;

	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "funcionario_departamento", joinColumns = @JoinColumn(name = "funcionario_id"), inverseJoinColumns = @JoinColumn(name = "departamento_id"))
	private Set<Departamento> departamentos;

	public Funcionario() {
	}

	public String getNomeFuncionario() {
		return nomeFuncionario;
	}

	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}

	public int getIdadeFuncionario() {
		return DateUtils.diferencaEmAnos(LocalDate.now(), dataNascFuncionario);
	}

	public LocalDate getDataNascFuncionario() {
		return dataNascFuncionario;
	}

	public void setDataNascFuncionario(LocalDate dataNascFuncionario) {
		this.dataNascFuncionario = dataNascFuncionario;
	}

	public String getDocumentoFuncionario() {
		return documentoFuncionario;
	}

	public void setDocumentoFuncionario(String documentoFuncionario) {
		this.documentoFuncionario = documentoFuncionario;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Set<Departamento> getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(Set<Departamento> departamentos) {
		this.departamentos = departamentos;
	}

	private void addDepartamento(Departamento departamento) {
		if (this.departamentos.contains(departamento)) {
			return;
		}
		this.departamentos.add(departamento);
	}

	private void deleteDepartamento(Departamento departamento) {
		if (!this.departamentos.contains(departamento)) {
			return;
		}
		this.departamentos.remove(departamento);
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.addDepartamento(departamento);
		this.departamento = departamento;
	}

}
