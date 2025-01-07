package artinfokorea.clavento.system.controller.dto.response;

import artinfokorea.clavento.system.UploadFileEntity;

public record FileResponse(
	Long id,
	String fileName,
	String url,
	Long size,
	String contentType
) {
	public FileResponse(UploadFileEntity uploadFileEntity) {
		this(
			uploadFileEntity.getId(),
			uploadFileEntity.getOriginalFileName(),
			uploadFileEntity.getUrl(),
			uploadFileEntity.getSize(),
			uploadFileEntity.getContentType()
		);
	}
}