package cqu.mve.ResearchPlatformBackground.Project.Repo;

import cqu.mve.ResearchPlatformBackground.Project.Project;
import org.hibernate.dialect.MySQLStorageEngine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    // Custom query methods (if needed) can be defined here
    List<Project> findByTitleContaining(String keyword);
    List<Project> findByOwnerContaining(String keyword);
}
