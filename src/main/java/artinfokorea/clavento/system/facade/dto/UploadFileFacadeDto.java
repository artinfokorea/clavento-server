package artinfokorea.clavento.system.facade.dto;

import org.springframework.web.multipart.MultipartFile;

import artinfokorea.clavento.system.enums.UploadFileType;

public record UploadFileFacadeDto(
	MultipartFile multipartFile,
	UploadFileType type
) {
}
