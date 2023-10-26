package com.api.ars.dto;

public class FuncionarioGetDTO {

	private FuncionarioDataDTO funcionarioData;

	public FuncionarioGetDTO() {
	}

	public FuncionarioGetDTO(FuncionarioDataDTO funcionarioData) {
		super();
		this.funcionarioData = funcionarioData;
	}

	public FuncionarioDataDTO getFuncionarioData() {
		return funcionarioData;
	}

	public void setFuncionarioData(FuncionarioDataDTO funcionarioData) {
		this.funcionarioData = funcionarioData;
	}

}
