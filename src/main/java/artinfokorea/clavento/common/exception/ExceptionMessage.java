package artinfokorea.clavento.common.exception;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;

@Getter
public class ExceptionMessage {
	private final String errorNo;
	private final String message;
	private final Map<String, String> validation = new HashMap<>();

	public ExceptionMessage(ErrorType errorType) {
		this.errorNo = errorType.getErrorNo();
		this.message = errorType.getMessage();
	}

	public void addValidation(String fieldName, String errorMessage) {
		this.validation.put(fieldName, errorMessage);
	}
}
