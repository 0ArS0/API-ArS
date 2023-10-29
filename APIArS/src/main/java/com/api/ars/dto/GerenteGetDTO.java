package com.api.ars.dto;

public class GerenteGetDTO {

	private GerenteDataDTO gerenteData;
	
	public GerenteGetDTO() {
	}

	public GerenteGetDTO(GerenteDataDTO gerenteData) {
		super();
		this.gerenteData = gerenteData;
	}

	public GerenteDataDTO getGerenteData() {
		return gerenteData;
	}

	public void setGerenteData(GerenteDataDTO gerenteData) {
		this.gerenteData = gerenteData;
	}

}
