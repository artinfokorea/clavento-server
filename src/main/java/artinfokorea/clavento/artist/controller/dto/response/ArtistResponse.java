package artinfokorea.clavento.artist.controller.dto.response;

import java.time.LocalDateTime;

import artinfokorea.clavento.artist.ArtistEntity;
import artinfokorea.clavento.artist.enums.MajorCategory;

public record ArtistResponse(
	Long id,
	MajorCategory major,
	String name,
	String contents,
	String imageUrl,
	LocalDateTime createdAt
) {
	public ArtistResponse(ArtistEntity artistEntity) {
		this(
			artistEntity.getId(),
			artistEntity.getMajor(),
			artistEntity.getName(),
			artistEntity.getContents(),
			artistEntity.getImageUrl(),
			artistEntity.getCreatedAt()
		);
	}
}
