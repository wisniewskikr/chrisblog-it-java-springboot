package com.example.jsons;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DirtyReadJson {
	
	@JsonProperty(value = "Dirty Read - message before roll out (expected null)")
	private String dirtyReadBeforeRollOut;
	@JsonProperty(value = "Dirty Read - message after roll out (expected null)")
	private String dirtyReadAfterRollOut;
	
	public DirtyReadJson() {}

	public DirtyReadJson(String dirtyReadBeforeRollOut, String dirtyReadAfterRollOut) {
		this.dirtyReadBeforeRollOut = dirtyReadBeforeRollOut;
		this.dirtyReadAfterRollOut = dirtyReadAfterRollOut;
	}

	public String getDirtyReadBeforeRollOut() {
		return dirtyReadBeforeRollOut;
	}

	public void setDirtyReadBeforeRollOut(String dirtyReadBeforeRollOut) {
		this.dirtyReadBeforeRollOut = dirtyReadBeforeRollOut;
	}

	public String getDirtyReadAfterRollOut() {
		return dirtyReadAfterRollOut;
	}

	public void setDirtyReadAfterRollOut(String dirtyReadAfterRollOut) {
		this.dirtyReadAfterRollOut = dirtyReadAfterRollOut;
	}	

}
