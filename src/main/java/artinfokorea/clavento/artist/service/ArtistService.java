package artinfokorea.clavento.artist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import artinfokorea.clavento.artist.ArtistEntity;
import artinfokorea.clavento.artist.controller.dto.response.ArtistResponse;
import artinfokorea.clavento.artist.repository.ArtistRepository;
import artinfokorea.clavento.artist.service.dto.CreateArtistServiceDto;
import artinfokorea.clavento.artist.service.dto.ScanArtistsServiceDto;
import artinfokorea.clavento.common.exception.CoreException;
import artinfokorea.clavento.common.exception.ErrorType;
import artinfokorea.clavento.system.UploadFileEntity;
import artinfokorea.clavento.system.service.UploadFileService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ArtistService {
	@Value("${admin.password}")
	private String adminPassword;

	private final ArtistRepository artistRepository;
	private final UploadFileService uploadFileService;

	public List<ArtistResponse> scanArtists(ScanArtistsServiceDto dto) {
		Pageable pageable = PageRequest.of(dto.page() - 1, dto.size());

		return artistRepository.findByKeywordAndMajor(pageable, dto.keyword(), dto.major())
			.stream()
			.map(ArtistResponse::new)
			.toList();
	}

	public ArtistResponse scanArtist(Long id) {
		ArtistEntity artistEntity = artistRepository.findById(id)
			.orElseThrow(() -> new CoreException(ErrorType.ARTIST_NOT_FOUND));

		return new ArtistResponse(artistEntity);
	}

	public Long createArtist(CreateArtistServiceDto dto) {
		if (!adminPassword.equals(dto.password())) {
			throw new CoreException(ErrorType.INVALID_ADMIN_PASSWORD);
		}

		UploadFileEntity uploadFile = uploadFileService.scanUploadFile(dto.fileId());
		ArtistEntity artist = artistRepository.save(
			ArtistEntity.builder()
				.major(dto.major())
				.name(dto.name())
				.contents(dto.contents())
				.imageUrl(uploadFile.getUrl())
				.build()
		);

		return artist.getId();
	}
}
