package cqu.mve.ResearchPlatformBackground.Evaluation.Repo;

import cqu.mve.ResearchPlatformBackground.Evaluation.Aspect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AspectRepository extends JpaRepository<Aspect, Long> {
}
