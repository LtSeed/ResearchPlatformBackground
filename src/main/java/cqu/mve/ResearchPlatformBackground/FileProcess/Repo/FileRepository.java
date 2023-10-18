package cqu.mve.ResearchPlatformBackground.FileProcess.Repo;

import cqu.mve.ResearchPlatformBackground.FileProcess.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<FileEntity, Long> {

}
