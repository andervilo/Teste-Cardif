package com.cardif.teste.model.dto;

import java.time.LocalDate;

import com.cardif.teste.arquitetura.dto.IEntityDTO;

public class FuncionarioInputDTO implements IEntityDTO {

	private static final long serialVersionUID = -4780615306781560595L;

	private String nomeFuncionario;

	private LocalDate dataNascFuncionario;

	private String documentoFuncionario;

	private Long cargoId;

	public FuncionarioInputDTO() {

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

	public Long getCargoId() {
		return cargoId;
	}

	public void setCargoId(Long cargoId) {
		this.cargoId = cargoId;
	}

}
