package com.api.ars.dto;

public class DepartamentoDataDTO {
	
	private String localidadeDepartamento;
	private String cepDepartamento;
	private String emailDepartamento;
	private String telefoneDepartamento;
	private String setorDepartamento;

	public DepartamentoDataDTO(String localidadeDepartamento, String cepDepartamento,
			String emailDepartamento, String telefoneDepartamento, String setorDepartamento) {
		super();
		this.localidadeDepartamento = localidadeDepartamento;
		this.cepDepartamento = cepDepartamento;
		this.emailDepartamento = emailDepartamento;
		this.telefoneDepartamento = telefoneDepartamento;
		this.setorDepartamento = setorDepartamento;
	}

	public DepartamentoDataDTO() {
	}

	public String getLocalidadeDepartamento() {
		return localidadeDepartamento;
	}

	public void setLocalidadeDepartamento(String localidadeDepartamento) {
		this.localidadeDepartamento = localidadeDepartamento;
	}

	public String getCepDepartamento() {
		return cepDepartamento;
	}

	public void setCepDepartamento(String cepDepartamento) {
		this.cepDepartamento = cepDepartamento;
	}

	public String getEmailDepartamento() {
		return emailDepartamento;
	}

	public void setEmailDepartamento(String emailDepartamento) {
		this.emailDepartamento = emailDepartamento;
	}

	public String getTelefoneDepartamento() {
		return telefoneDepartamento;
	}

	public void setTelefoneDepartamento(String telefoneDepartamento) {
		this.telefoneDepartamento = telefoneDepartamento;
	}

	public String getSetorDepartamento() {
		return setorDepartamento;
	}

	public void setSetorDepartamento(String setorDepartamento) {
		this.setorDepartamento = setorDepartamento;
	}

}
