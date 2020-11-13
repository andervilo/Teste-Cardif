package com.cardif.teste.model.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.cardif.teste.arquitetura.dto.IEntityDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

public class FuncionarioInputDTO implements IEntityDTO {

	private static final long serialVersionUID = -4780615306781560595L;
	
	@ApiModelProperty(position = 1, required = true)
	@NotNull(message = "Campo id é obrigatório!")
	@JsonProperty(required = true)
	private Long id;

	@ApiModelProperty(position = 2, required = true, example = "Dom Pedro II")
	@NotBlank(message = "Campo nomeFuncionario é obrigatório!")
	@NotNull(message = "Campo nomeFuncionario é obrigatório!")
	private String nomeFuncionario;

	@ApiModelProperty(dataType = "LocalDate", example = "2000-10-15", required = true, position = 3)
	@NotNull(message = "Campo dataNascFuncionario é obrigatório!")
	private LocalDate dataNascFuncionario;

	@ApiModelProperty(example = "999.999.999-99", position = 4, required = true)
	@NotBlank(message = "Campo documentoFuncionario é obrigatório!")
	@NotNull(message = "Campo documentoFuncionario é obrigatório!")
	private String documentoFuncionario;

	@ApiModelProperty(position = 5, required = true)
	@NotNull(message = "Campo cargoId é obrigatório!")
	private Long cargoId;
	
	@ApiModelProperty(position = 6, required = true)
	@NotNull(message = "Campo departamentoId é obrigatório!")
	private Long departamentoId;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDepartamentoId() {
		return departamentoId;
	}

	public void setDepartamentoId(Long departamentoId) {
		this.departamentoId = departamentoId;
	}

}
