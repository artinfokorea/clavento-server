package artinfokorea.clavento.common.annotation.enums;

import java.util.List;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EnumListValidator implements ConstraintValidator<ValidEnumList, List<? extends Enum<?>>> {
	private ValidEnumList annotation;

	@Override
	public void initialize(ValidEnumList constraintAnnotation) {
		this.annotation = constraintAnnotation;
	}

	@Override
	public boolean isValid(List<? extends Enum<?>> value, ConstraintValidatorContext context) {
		if (value == null && annotation.nullable()) {
			return true;
		}

		if (value == null) {
			return false;
		}

		for (Enum<?> enumValue : value) {
			if (enumValue == null) {
				return false;
			}

			Object[] enumValues = this.annotation.enumClass().getEnumConstants();
			boolean isValid = false;

			for (Object validEnumValue : enumValues) {
				if (validEnumValue == enumValue) {
					isValid = true;
					break;
				}
			}

			if (!isValid) {
				return false;
			}
		}
		return true;
	}
}