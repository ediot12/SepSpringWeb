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
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userId", "required");//���� null�̰ų� ���̰� 0�̰ų� ���� ���� ���ڷ� �����Ǿ� �ִ� ��� ���� �ڵ带 �߰�
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required");
		

		//�����ڵ�.��üŸ��.�ʵ��
		//�����ڵ�.�ʵ��
		//�����ڵ�
	}
}
