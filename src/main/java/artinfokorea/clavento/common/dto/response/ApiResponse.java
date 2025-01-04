package artinfokorea.clavento.common.dto.response;

import artinfokorea.clavento.common.enums.ResultType;
import artinfokorea.clavento.common.exception.ErrorType;
import artinfokorea.clavento.common.exception.ExceptionMessage;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ApiResponse<T> {

	@Schema(description = "응답 타입", defaultValue = "SUCCESS")
	private ResultType type;

	@Schema(description = "응답 에러 메세지")
	private ExceptionMessage exception;

	@Schema(description = "응답 데이터")
	private T data;

	public static <T> ApiResponse<T> success(T data) {
		return new ApiResponse<>(ResultType.SUCCESS, null, data);
	}

	public static <T> ApiResponse<T> fail(ErrorType errorType) {
		return new ApiResponse<>(ResultType.FAIL, new ExceptionMessage(errorType), null);
	}

	public ApiResponse(ResultType resultType, ExceptionMessage exception, T data) {
		this.type = resultType;
		this.exception = exception;
		this.data = data;
	}
}
