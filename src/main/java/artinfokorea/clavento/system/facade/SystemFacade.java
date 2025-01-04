package artinfokorea.clavento.system.facade;

import org.springframework.stereotype.Component;

import artinfokorea.clavento.aws.AwsS3Service;
import artinfokorea.clavento.aws.dto.info.AwsS3UploadFileInfo;
import artinfokorea.clavento.system.facade.dto.UploadFileFacadeDto;
import artinfokorea.clavento.system.service.UploadFileService;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SystemFacade {
	private final AwsS3Service awsS3Service;
	private final UploadFileService uploadFileService;

	public Long uploadFile(UploadFileFacadeDto dto) {
		AwsS3UploadFileInfo awsS3UploadFileInfo = this.awsS3Service.uploadFile(dto.multipartFile());
		return uploadFileService.createUploadFile(awsS3UploadFileInfo.toCreateUploadFileServiceDto(dto.type()));
	}
}
