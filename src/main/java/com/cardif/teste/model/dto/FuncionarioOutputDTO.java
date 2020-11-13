package com.cardif.teste.model.dto;

import java.time.LocalDate;

import com.cardif.teste.arquitetura.dto.IEntityDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

public class FuncionarioOutputDTO implements IEntityDTO {

	private static final long serialVersionUID = -4780615306781560595L;

	@ApiModelProperty(position = 1)
	private Long id;

	@ApiModelProperty(position = 2)
	private String nomeFuncionario;
	
	@ApiModelProperty(position = 3)
	private int idadeFuncionario;

	@ApiModelProperty(position = 4)
	private LocalDate dataNascFuncionario;

	@ApiModelProperty(position = 5)
	private String documentoFuncionario;

	@JsonProperty("cargo")
	@ApiModelProperty(position = 6)
	private String cargoNomeCargo;

	@JsonProperty("departamento")
	@ApiModelProperty(position = 7)
	private String departamentoNomeDepartamento;

	public FuncionarioOutputDTO() {

	}

	public String getNomeFuncionario() {
		return nomeFuncionario;
	}

	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCargoNomeCargo() {
		return cargoNomeCargo;
	}

	public void setCargoNomeCargo(String cargoNomeCargo) {
		this.cargoNomeCargo = cargoNomeCargo;
	}

	public String getDepartamentoNomeDepartamento() {
		return departamentoNomeDepartamento;
	}

	public void setDepartamentoNomeDepartamento(String departamentoNomeDepartamento) {
		this.departamentoNomeDepartamento = departamentoNomeDepartamento;
	}

	public int getIdadeFuncionario() {
		return idadeFuncionario;
	}

	public void setIdadeFuncionario(int idadeFuncionario) {
		this.idadeFuncionario = idadeFuncionario;
	}
	
}
