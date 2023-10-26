package com.api.ars.enums;

public enum TipoRoleEnum {

	ROLE_USUARIO("USUARIO"),
	ROLE_FUNCIONARIO("FUNCIONARIO");

	private String tipo;

	TipoRoleEnum(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}
	
}