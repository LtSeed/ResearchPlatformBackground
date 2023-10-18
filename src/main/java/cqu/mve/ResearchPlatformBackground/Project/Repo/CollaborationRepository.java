package cqu.mve.ResearchPlatformBackground.Project.Repo;

import cqu.mve.ResearchPlatformBackground.Project.Collaboration.Collaboration;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollaborationRepository extends JpaRepository<Collaboration, Long> {
    // Custom query methods (if needed) can be defined here
    List<Collaboration> findByProjectId(Long projectId);

}