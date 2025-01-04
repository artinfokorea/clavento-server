package artinfokorea.clavento.aws.dto.info;

import artinfokorea.clavento.system.enums.UploadFileType;
import artinfokorea.clavento.system.service.dto.CreateUploadFileServiceDto;

public record AwsS3UploadFileInfo(
	String originalFileName,
	String url,
	Long size,
	String contentType
) {
	public CreateUploadFileServiceDto toCreateUploadFileServiceDto(UploadFileType uploadFileType) {
		return new CreateUploadFileServiceDto(
			originalFileName,
			url,
			size,
			contentType,
			uploadFileType
		);
	}
}
