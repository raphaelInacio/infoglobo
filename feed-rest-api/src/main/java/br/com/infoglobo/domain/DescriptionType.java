package br.com.infoglobo.domain;

public enum DescriptionType {

	TEXT("text"), IMAGE("image"), LINKS("links");

	private DescriptionType(String type) {
		this.type = type;
	}

	private String type;

	public String getType() {
		return this.type;
	}
}
