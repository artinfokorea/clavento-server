package artinfokorea.clavento.system.service;

import org.springframework.stereotype.Service;

import artinfokorea.clavento.common.exception.CoreException;
import artinfokorea.clavento.common.exception.ErrorType;
import artinfokorea.clavento.system.UploadFileEntity;
import artinfokorea.clavento.system.repository.UploadFileRepository;
import artinfokorea.clavento.system.service.dto.CreateUploadFileServiceDto;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UploadFileService {
	private final UploadFileRepository uploadFileRepository;

	public Long createUploadFile(CreateUploadFileServiceDto dto) {
		UploadFileEntity uploadFileEntity = uploadFileRepository.save(
			UploadFileEntity.builder()
				.originalFileName(dto.originalFileName())
				.url(dto.url())
				.size(dto.size())
				.contentType(dto.contentType())
				.type(dto.type())
				.build()
		);

		return uploadFileEntity.getId();
	}

	public UploadFileEntity scanUploadFile(Long id) {
		return uploadFileRepository.findById(id).orElseThrow(() -> new CoreException(ErrorType.UPLOAD_FILE_NOT_FOUND));
	}
}

