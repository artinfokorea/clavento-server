package artinfokorea.clavento.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import artinfokorea.clavento.system.UploadFileEntity;

public interface UploadFileRepository extends JpaRepository<UploadFileEntity, Long> {
}
