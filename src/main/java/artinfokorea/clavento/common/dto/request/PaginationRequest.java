package artinfokorea.clavento.common.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaginationRequest {
	@Schema(description = "페이지 번호", defaultValue = "1")
	@Min(value = 1, message = "페이지 번호는 1 이상이어야 합니다.")
	int page;

	@Schema(description = "아이템 개수", defaultValue = "10")
	@Min(value = 1, message = "아이템 개수는 1 이상이어야 합니다.")
	@Max(value = 100, message = "아이템 개수는 100 이하로 설정해야 합니다.")
	int size;
}
