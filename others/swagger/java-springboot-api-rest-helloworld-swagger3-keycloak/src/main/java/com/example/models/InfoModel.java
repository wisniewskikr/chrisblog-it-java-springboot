package com.example.models;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Model of Info")
public class InfoModel {

	@Schema(description = "Content of info", example = "Info")
    private String info;
	
	public InfoModel() {}

	public InfoModel(String info) {
		this.info = info;
	}

	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}

}
