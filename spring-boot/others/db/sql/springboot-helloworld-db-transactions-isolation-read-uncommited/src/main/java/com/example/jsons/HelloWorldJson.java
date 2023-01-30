package com.example.jsons;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HelloWorldJson {
	
	@JsonProperty(value = "Dirty Read")
	private DirtyReadJson dirtyReadJson;
	@JsonProperty(value = "Not Repetable Read")
	private NotRepetableReadJson notRepetableReadJson;
	@JsonProperty(value = "Phantom Read")
	private PhantomReadJson phantomReadJson;
	
	public HelloWorldJson(DirtyReadJson dirtyReadJson, NotRepetableReadJson notRepetableReadJson,
			PhantomReadJson phantomReadJson) {
		this.dirtyReadJson = dirtyReadJson;
		this.notRepetableReadJson = notRepetableReadJson;
		this.phantomReadJson = phantomReadJson;
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

	public PhantomReadJson getPhantomReadJson() {
		return phantomReadJson;
	}

	public void setPhantomReadJson(PhantomReadJson phantomReadJson) {
		this.phantomReadJson = phantomReadJson;
	}	

}
