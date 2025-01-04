package artinfokorea.clavento.artist.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import artinfokorea.clavento.artist.ArtistEntity;
import artinfokorea.clavento.artist.enums.MajorCategory;

public interface ArtistRepository extends JpaRepository<ArtistEntity, Long> {
	@Query("SELECT a FROM ArtistEntity a WHERE " +
		"(COALESCE(:keyword, '') = '' OR a.name LIKE %:keyword% OR a.contents LIKE %:keyword%) AND " +
		"(COALESCE(:major, '') = '' OR a.major = :major) " +
		"ORDER BY a.createdAt DESC")
	Page<ArtistEntity> findByKeywordAndMajor(Pageable pageable, Optional<String> keyword,
		Optional<MajorCategory> major);
}
