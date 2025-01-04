package artinfokorea.clavento.artist.controller.dto.request;

import artinfokorea.clavento.artist.enums.MajorCategory;
import artinfokorea.clavento.artist.service.dto.CreateArtistServiceDto;
import artinfokorea.clavento.common.annotation.enums.ValidEnum;
import io.swagger.v3.oas.annotations.media.Schema;

public record CreateArtistRequest(
	@Schema(description = "이름 또는 단체명", defaultValue = "정명훈")
	String name,

	@Schema(description = "아티스트 프로필", defaultValue = "베를린필 지휘자")
	String contents,

	@Schema(description = "아티스트 전공")
	@ValidEnum(enumClass = MajorCategory.class)
	MajorCategory major,

	@Schema(description = "이미지 아이디", defaultValue = "1")
	Long fileId,

	@Schema(description = "관리자 비밀번호", defaultValue = "1234")
	String password
) {

	public CreateArtistServiceDto toCreateArtistServiceDto() {
		return new CreateArtistServiceDto(
			name,
			contents,
			major,
			fileId,
			password
		);
	}
}
