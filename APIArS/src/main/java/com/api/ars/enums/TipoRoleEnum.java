package com.api.ars.enums;

public enum TipoRoleEnum {

	ROLE_GERENTE("GERENTE"),
	ROLE_FUNCIONARIO("FUNCIONARIO");

	private String tipo;

	TipoRoleEnum(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}
	
}