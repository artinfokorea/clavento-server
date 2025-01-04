package artinfokorea.clavento.artist.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import artinfokorea.clavento.artist.controller.dto.request.CreateArtistRequest;
import artinfokorea.clavento.artist.controller.dto.response.ArtistResponse;
import artinfokorea.clavento.artist.enums.MajorCategory;
import artinfokorea.clavento.artist.service.ArtistService;
import artinfokorea.clavento.artist.service.dto.ScanArtistsServiceDto;
import artinfokorea.clavento.common.dto.response.ApiResponse;
import artinfokorea.clavento.common.dto.response.CreateResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;

@Tag(name = "ARTIST")
@RestController
@RequiredArgsConstructor
@RequestMapping("/artists")
public class ArtistController {
	private final ArtistService artistService;

	@GetMapping
	public ApiResponse<List<ArtistResponse>> scanMaterial(
		@Schema(description = "페이지 번호", defaultValue = "1")
		@Min(value = 1, message = "페이지 번호는 1 이상이어야 합니다.")
		int page,

		@Schema(description = "아이템 개수", defaultValue = "10")
		@Min(value = 1, message = "아이템 개수는 1 이상이어야 합니다.")
		@Max(value = 100, message = "아이템 개수는 100 이하로 설정해야 합니다.")
		int size,
		Optional<String> keyword,
		Optional<MajorCategory> major
	) {
		return ApiResponse.success(artistService.scanArtists(new ScanArtistsServiceDto(
			page, size, keyword, major
		)));
	}

	@GetMapping("/{artistId}")
	public ApiResponse<ArtistResponse> getArtist(@PathVariable Long artistId) {
		return ApiResponse.success(artistService.scanArtist(artistId));
	}

	@PostMapping
	public ApiResponse<CreateResponse> createArtist(@RequestBody CreateArtistRequest request) {
		return ApiResponse.success(new CreateResponse(artistService.createArtist(request.toCreateArtistServiceDto())));
	}
}
