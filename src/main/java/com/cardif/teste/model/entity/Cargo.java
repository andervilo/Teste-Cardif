package com.cardif.teste.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.cardif.teste.arquitetura.entity.BaseEntity;

@Entity
public class Cargo extends BaseEntity {

	private static final long serialVersionUID = 3181837792937840773L;

	@Column(name = "cargo_name")
	private String nomeCargo;

	public Cargo() {

	}

	public String getNomeCargo() {
		return nomeCargo;
	}

	public void setNomeCargo(String nomeCargo) {
		this.nomeCargo = nomeCargo;
	}

}
