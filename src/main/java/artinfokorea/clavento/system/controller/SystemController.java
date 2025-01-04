package artinfokorea.clavento.system.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import artinfokorea.clavento.common.dto.response.ApiResponse;
import artinfokorea.clavento.system.controller.dto.request.UploadFileRequest;
import artinfokorea.clavento.system.facade.SystemFacade;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "SYSTEM")
@RestController
@RequiredArgsConstructor
@RequestMapping("/system")
public class SystemController {
	private final SystemFacade systemFacade;

	@PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ApiResponse<Long> uploadFile(UploadFileRequest request) {
		return ApiResponse.success(systemFacade.uploadFile(request.toUploadFileFacadeDto()));
	}
}
