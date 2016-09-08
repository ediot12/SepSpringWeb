package web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.model.Address;
import spring.model.MemberInfo;
import spring.validator.MemberInfoValidator;

@Controller
@RequestMapping("/account/create.do")
public class CreateAccountController {
	
	@ModelAttribute("command")
	public MemberInfo formBacking(HttpServletRequest request){
		if(request.getMethod().equalsIgnoreCase("GET")){//equalsIgnoreCase 대소문자 무시함
			MemberInfo mi = new MemberInfo();
			Address address = new Address();
			address.setZipcode(autoDetectZipcode(request.getRemoteAddr()));
			mi.setAddress(address);
			return mi;
		}
		else{
			return new MemberInfo();
		}
	}
	
	private String autoDetectZipcode(String remoteAddr){
		return "000-000";
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String form(){
		return "account/creationForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String submit(@ModelAttribute("command") MemberInfo memberInfo,BindingResult result){//command라는 이름이 같은데 위에 ModelAttribute에서 만들어둔 객체를 memberInfo에 주입을 시키는거다.
		new MemberInfoValidator().validate(memberInfo, result);
		if (result.hasErrors()) {
			return "account/creationForm";
		}//멀쩡히 입력잘하면 에러를 추가할일이 없어서 그냥 바로 아래 return이 되는거임
		return "account/created";
	}

}
