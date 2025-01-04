package artinfokorea.clavento.artist.repository.dto;

import java.util.Optional;

import artinfokorea.clavento.artist.enums.MajorCategory;

public record FindPageArtistsQuery(
	int page,
	int size,
	Optional<String> keyword,
	Optional<MajorCategory> major
) {
}
