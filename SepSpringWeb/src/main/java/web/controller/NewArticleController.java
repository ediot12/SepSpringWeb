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

	
	//requestmapping �޼����� �Ű������� ���޵� ��ü�� �� �����͎� view�� ������ ��.
	//�̶� key���� Ÿ�Ը�(ù���� �ҹ���)�� Ű �̸����� ����.. �Ʒ��� ���� �̸��� �����ѰŰ�
//	/@ModelAttribute:model�� ������ �߰��� key���� ( �Ƚᵵ �߰� ��ü�� ��)
	@RequestMapping(method = RequestMethod.POST)
	public String submit(@ModelAttribute("command") NewArticleCommand command) {
		articleService.wrtieArticle(command);
		return "article/newArticleSubmit";
	}

	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

}
