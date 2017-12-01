package com.practice;

public class SubPattern {
	
	private String id;
	private String PatternId;
	private String value1;
	private String value2;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPatternId() {
		return PatternId;
	}
	public void setPatternId(String patternId) {
		PatternId = patternId;
	}
	public String getValue1() {
		return value1;
	}
	public void setValue1(String value1) {
		this.value1 = value1;
	}
	public String getValue2() {
		return value2;
	}
	public void setValue2(String value2) {
		this.value2 = value2;
	}
	@Override
	public String toString() {
		return "SubPattern [id=" + id + ", PatternId=" + PatternId + ", value1=" + value1 + ", value2=" + value2 + "]";
	}
	
}
