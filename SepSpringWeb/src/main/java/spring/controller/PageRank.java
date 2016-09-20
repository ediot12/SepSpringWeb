package spring.controller;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


//Ŭ���� �տ� ����ϸ� xml�� ���� ���� ����
@XmlAccessorType(XmlAccessType.FIELD)//�ʵ带 ��� �����Ѵ�.
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
