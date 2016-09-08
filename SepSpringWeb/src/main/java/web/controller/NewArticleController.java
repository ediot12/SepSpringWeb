package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.service.ArticleService;
import spring.service.NewArticleCommand;


@Controller
@RequestMapping("/article/newArticle.do")
public class NewArticleController {
	
	@Autowired
	private ArticleService articleService;

	@RequestMapping(method = RequestMethod.GET)
	public String form() {
		return "article/newArticleForm";
	}

	
	//requestmapping 메서드의 매개변수로 전달된 객체는 모델 데이터롣 view에 전달이 됨.
	//이때 key값은 타입명(첫글자 소문자)를 키 이르으로 사용됨.. 아래는 직접 이름을 지정한거고
//	/@ModelAttribute:model에 데이터 추가시 key지정 ( 안써도 추가 자체는 됨)
	@RequestMapping(method = RequestMethod.POST)
	public String submit(@ModelAttribute("command") NewArticleCommand command) {
		articleService.wrtieArticle(command);
		return "article/newArticleSubmit";
	}

	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

}
