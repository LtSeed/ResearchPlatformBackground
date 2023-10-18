package cqu.mve.ResearchPlatformBackground.User.Repo;

import cqu.mve.ResearchPlatformBackground.User.Permission.Inspector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InspectorRepository extends JpaRepository<Inspector, Long> {
    Optional<Inspector> findById(Long id);
}