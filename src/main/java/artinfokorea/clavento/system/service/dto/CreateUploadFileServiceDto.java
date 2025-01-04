package artinfokorea.clavento.system.service.dto;

import artinfokorea.clavento.system.enums.UploadFileType;

public record CreateUploadFileServiceDto(
	String originalFileName,
	String url,
	Long size,
	String contentType,
	UploadFileType type
) {
}
