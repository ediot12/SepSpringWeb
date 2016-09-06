package spring.service;

public class ArticleService {
	
	public void wrtieArticle(NewArticleCommand command){
		System.out.println("신규 게시글 등록 : "  +command);
	}

}
