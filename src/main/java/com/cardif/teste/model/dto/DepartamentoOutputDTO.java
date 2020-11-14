package com.cardif.teste.model.dto;

import com.cardif.teste.arquitetura.dto.IEntityDTO;

import io.swagger.annotations.ApiModelProperty;

public class DepartamentoOutputDTO implements IEntityDTO {

	private static final long serialVersionUID = -1953463657965551127L;

	@ApiModelProperty(position = 1)
	private Long id;

	@ApiModelProperty(position = 2)
	private String nomeDepartamento;

	@ApiModelProperty(position = 3)
	private FuncionarioOutputDTO chefe;

	public DepartamentoOutputDTO() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeDepartamento() {
		return nomeDepartamento;
	}

	public void setNomeDepartamento(String nomeDepartamento) {
		this.nomeDepartamento = nomeDepartamento;
	}

	public FuncionarioOutputDTO getChefe() {
		return chefe;
	}

	public void setChefe(FuncionarioOutputDTO chefe) {
		this.chefe = chefe;
	}

}
