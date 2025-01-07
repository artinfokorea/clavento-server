package artinfokorea.clavento.system.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import artinfokorea.clavento.common.dto.response.ApiResponse;
import artinfokorea.clavento.common.dto.response.CreateResponse;
import artinfokorea.clavento.system.controller.dto.request.UploadFileRequest;
import artinfokorea.clavento.system.controller.dto.response.FileResponse;
import artinfokorea.clavento.system.facade.SystemFacade;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "SYSTEM")
@RestController
@RequiredArgsConstructor
@RequestMapping("/system")
public class SystemController {
	private final SystemFacade systemFacade;

	@PostMapping(value = "/files", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ApiResponse<CreateResponse> uploadFile(UploadFileRequest request) {
		return ApiResponse.success(new CreateResponse(systemFacade.uploadFile(request.toUploadFileFacadeDto())));
	}

	@GetMapping("/files/{fileId}")
	public ApiResponse<FileResponse> getFile(@PathVariable Long fileId) {
		return ApiResponse.success(new FileResponse(systemFacade.scanUploadFile(fileId)));
	}
}
