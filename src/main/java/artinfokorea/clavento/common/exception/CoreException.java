package artinfokorea.clavento.common.exception;

import lombok.Getter;

@Getter
public class CoreException extends RuntimeException {
	private final ErrorType errorType;

	public CoreException(ErrorType errorType) {
		super(errorType.getMessage());
		this.errorType = errorType;
	}

	public ErrorType getErrorType() {
		return errorType;
	}

}
