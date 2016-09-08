package spring.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import spring.service.LoginCommand;

public class LoginCommandValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return LoginCommand.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userId", "required");//값이 null이거나 길이가 0이거나 값이 공백 문자로 구성되어 있는 경우 에러 코드를 추가
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required");
		

		//에러코드.객체타입.필드명
		//에러코드.필드명
		//에러코드
	}
}
