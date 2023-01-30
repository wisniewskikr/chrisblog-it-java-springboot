package com.example.jsons;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HelloWorldJson {
	
	@JsonProperty(value = "Dirty Read")
	private DirtyReadJson dirtyReadJson;
	@JsonProperty(value = "Not Repetable Read")
	private NotRepetableReadJson notRepetableReadJson;
	
	public HelloWorldJson(DirtyReadJson dirtyReadJson, NotRepetableReadJson notRepetableReadJson) {
		this.dirtyReadJson = dirtyReadJson;
		this.notRepetableReadJson = notRepetableReadJson;
	}

	public DirtyReadJson getDirtyReadJson() {
		return dirtyReadJson;
	}

	public void setDirtyReadJson(DirtyReadJson dirtyReadJson) {
		this.dirtyReadJson = dirtyReadJson;
	}

	public NotRepetableReadJson getNotRepetableReadJson() {
		return notRepetableReadJson;
	}

	public void setNotRepetableReadJson(NotRepetableReadJson notRepetableReadJson) {
		this.notRepetableReadJson = notRepetableReadJson;
	}	

}
