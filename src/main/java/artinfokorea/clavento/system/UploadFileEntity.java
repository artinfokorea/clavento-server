package artinfokorea.clavento.system;

import java.time.LocalDateTime;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import artinfokorea.clavento.system.enums.UploadFileType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
@SQLDelete(sql = "UPDATE file SET deleted_at = NOW() WHERE id = ?")
@SQLRestriction("deleted_at is NULL")
@Table(name = "file")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UploadFileEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "original_file_name", nullable = false)
	private String originalFileName;

	@Column(columnDefinition = "text", name = "url", nullable = false)
	private String url;

	@Column(columnDefinition = "bigint", name = "size", nullable = false)
	private Long size;

	@Column(name = "content_type", nullable = false)
	private String contentType;

	@Enumerated(EnumType.STRING)
	@Column(name = "type", nullable = false)
	private UploadFileType type;

	@CreatedDate
	@Column(name = "created_at", updatable = false, nullable = false)
	private LocalDateTime createdAt;

	@LastModifiedDate
	@Column(name = "updated_at", nullable = false)
	private LocalDateTime updatedAt;

	@Column(name = "deleted_At")
	private LocalDateTime deletedAt;

	@Builder
	public UploadFileEntity(Long id, String originalFileName, String url, Long size, String contentType,
		UploadFileType type, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt) {
		this.id = id;
		this.originalFileName = originalFileName;
		this.url = url;
		this.size = size;
		this.contentType = contentType;
		this.type = type;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}
}