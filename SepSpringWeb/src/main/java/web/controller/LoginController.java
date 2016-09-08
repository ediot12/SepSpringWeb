package web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.service.AuthenticationException;
import spring.service.Authenticator;
import spring.service.LoginCommand;
import spring.validator.LoginCommandValidator;

@Controller
@RequestMapping("/login/login.do")
public class LoginController {

	private String formViewName = "login/form";

	@Autowired
	private Authenticator authenticator;

	@RequestMapping(method = RequestMethod.GET)
	public String form() {
		return formViewName;
	}

	@ModelAttribute
	public LoginCommand formBacking() {
		return new LoginCommand();
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submit(@Valid LoginCommand loginCommand, BindingResult result) {
		if (result.hasErrors()) {
			return formViewName;
		}
		try {
			authenticator.authenticate(loginCommand);
			return "redirect:/index.jsp";
		} catch (AuthenticationException e) {
			result.reject("invalidIdOrPassword", new Object[] { loginCommand.getUserId() }, null);
			//객체 전체에 에러가 있을때
			return formViewName;
		}
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new LoginCommandValidator());
	}//InitBinder(WebdataBinder) 를 사용하여 사용하는경우 @ModelAttribute를 사용하지 않아도 
	//@Valid만 사용하여 값들이 자동 binding되는 결과물들을 얻을 수 있다.
	//원래는 submit에서 유효성검사를 하기 위해 직접 호출을 해야하는데 initbinder 어노테이션을 사용하면 
	//직접 호출 없이 유효성 검사를 할 수 있음.

	public void setAuthenticator(Authenticator loginService) {
		this.authenticator = loginService;
	}
}
