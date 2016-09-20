package spring.tiles.controller;

public class Code {

	private String cide;
	private String label;

	public Code() {

	}

	public String getCide() {
		return cide;
	}

	public void setCide(String cide) {
		this.cide = cide;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Code(String cide, String label) {
		super();
		this.cide = cide;
		this.label = label;
	}

}
