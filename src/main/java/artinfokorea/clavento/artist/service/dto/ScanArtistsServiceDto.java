package artinfokorea.clavento.artist.service.dto;

import java.util.Optional;

import artinfokorea.clavento.artist.enums.MajorCategory;
import artinfokorea.clavento.artist.repository.dto.FindPageArtistsQuery;

public record ScanArtistsServiceDto(
	int page,
	int size,
	Optional<String> keyword,
	Optional<MajorCategory> major
) {
	public FindPageArtistsQuery toQuery() {
		return new FindPageArtistsQuery(
			page,
			size,
			keyword,
			major
		);
	}
}
