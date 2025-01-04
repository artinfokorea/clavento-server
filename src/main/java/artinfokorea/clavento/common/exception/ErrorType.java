package artinfokorea.clavento.common.exception;

import org.springframework.boot.logging.LogLevel;

import lombok.Getter;

@Getter
public enum ErrorType {
	// server
	INTERNAL_SERVER_ERROR(ErrorCode.SERVER_ERROR, "E000001", "서버에서 오류가 발생했습니다. 요청을 처리할 수 없습니다.", LogLevel.ERROR),
	BAD_REQUEST(ErrorCode.CLIENT_ERROR, "E000002", "유효하지 않은 요청입니다.", LogLevel.INFO),

	// artist - 01
	ARTIST_NOT_FOUND(ErrorCode.NOT_FOUND, "E01001", "해당 아티스트가 존재하지 않습니다.", LogLevel.WARN),

	// file - 02
	UPLOAD_FILE_NOT_FOUND(ErrorCode.NOT_FOUND, "E02001", "해당 파일이 존재하지 않습니다.", LogLevel.WARN),

	// System - 03
	INVALID_ADMIN_PASSWORD(ErrorCode.CLIENT_ERROR, "E03001", "관리자 비밀번호가 올바르지 않습니다.", LogLevel.WARN);

	private final ErrorCode errorCode;
	private final String errorNo;
	private final String message;
	private final LogLevel logLevel;

	ErrorType(ErrorCode errorCode, String errorNo, String message, LogLevel logLevel) {
		this.errorCode = errorCode;
		this.errorNo = errorNo;
		this.message = message;
		this.logLevel = logLevel;
	}
}