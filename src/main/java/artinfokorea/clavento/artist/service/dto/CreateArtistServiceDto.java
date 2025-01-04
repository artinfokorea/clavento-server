package artinfokorea.clavento.artist.service.dto;

import artinfokorea.clavento.artist.enums.MajorCategory;

public record CreateArtistServiceDto(
	String name,
	String contents,
	MajorCategory major,
	Long fileId,
	String password
) {
}
