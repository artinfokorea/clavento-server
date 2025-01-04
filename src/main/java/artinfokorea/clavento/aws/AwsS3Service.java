package artinfokorea.clavento.aws;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.SdkClientException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

import artinfokorea.clavento.aws.dto.info.AwsS3UploadFileInfo;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AwsS3Service {
	@Value("${cloud.aws.s3.bucket}")
	private String bucket;
	private final AmazonS3 amazonS3;

	private static final String UPLOAD_DIRECTORY = "clavento/artist/";

	public AwsS3UploadFileInfo uploadFile(MultipartFile file) {
		String currentTime = LocalDateTime.now()
			.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
		String randomUUID = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 8);
		String uniqueFileName = UPLOAD_DIRECTORY + currentTime + "_" + randomUUID;

		try {
			ObjectMetadata metadata = new ObjectMetadata();
			metadata.setContentType(file.getContentType());

			amazonS3.putObject(
				new PutObjectRequest(bucket, uniqueFileName, file.getInputStream(), metadata)
					.withCannedAcl(CannedAccessControlList.PublicRead));
		} catch (SdkClientException e) {
			e.printStackTrace();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		return new AwsS3UploadFileInfo(
			file.getOriginalFilename(),
			amazonS3.getUrl(bucket, uniqueFileName).toString(),
			file.getSize(),
			file.getContentType()
		);
	}
}
