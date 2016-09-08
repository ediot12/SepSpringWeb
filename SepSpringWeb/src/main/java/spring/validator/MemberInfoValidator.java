package spring.validator;

import spring.model.Address;
import spring.model.MemberInfo;
import org.springframework.validation.Errors;

public class MemberInfoValidator {
	
	public boolean supports(Class<?> clazz){
		return MemberInfo.class.isAssignableFrom(clazz);
	}
	
	public void validate(Object target,Errors errors){
		MemberInfo memberInfo = (MemberInfo) target;
		if(memberInfo.getId() == null || memberInfo.getId().trim().isEmpty()){
			errors.rejectValue("id", "required");
		}
		if(memberInfo.getName() == null || memberInfo.getName().trim().isEmpty()){
			errors.rejectValue("name", "required");
		}
		Address address = memberInfo.getAddress();
		if(address == null){
			errors.rejectValue("address", "required");
		}
		if (address != null) {
			errors.pushNestedPath("address");
			try {
				if (address.getZipcode() == null || address.getZipcode().trim().isEmpty()) {
					errors.rejectValue("zipcode", "required");
				}
				if (address.getAddress1() == null || address.getAddress1().trim().isEmpty()) {
					errors.rejectValue("address1", "required");
				}
			} finally {
				errors.popNestedPath();
			}
		}
	}

}
