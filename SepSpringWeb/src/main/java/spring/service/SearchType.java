package spring.service;

public class SearchType {

	private int code;
	private String text;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public SearchType(int code, String text) {
		super();
		this.code = code;
		this.text = text;
	}

}
