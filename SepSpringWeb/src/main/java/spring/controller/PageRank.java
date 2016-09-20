package spring.controller;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


//클래스 앞에 사용하면 xml로 만들 범위 결정
@XmlAccessorType(XmlAccessType.FIELD)//필드를 모두 추출한다.
@XmlType(name = "", propOrder = { "rank", "page" })
public class PageRank {

	private int rank;
	private String page;

	public PageRank() {
		super();
	}

	public PageRank(int rank, String page) {
		super();
		this.rank = rank;
		this.page = page;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

}
