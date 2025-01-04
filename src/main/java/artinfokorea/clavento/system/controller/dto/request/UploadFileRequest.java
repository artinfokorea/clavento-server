package artinfokorea.clavento.system.controller.dto.request;

import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import artinfokorea.clavento.system.enums.UploadFileType;
import artinfokorea.clavento.system.facade.dto.UploadFileFacadeDto;

public record UploadFileRequest(
	@RequestPart("file")
	MultipartFile file,

	@RequestPart("type")
	UploadFileType type
) {

	public UploadFileFacadeDto toUploadFileFacadeDto() {
		return new UploadFileFacadeDto(this.file, this.type);
	}
}
