package cqu.mve.ResearchPlatformBackground.Review.Repo;

import cqu.mve.ResearchPlatformBackground.Project.Collaboration.Collaboration;
import cqu.mve.ResearchPlatformBackground.Review.ReviewRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRecordRepository extends JpaRepository<ReviewRecord, Long> {
    // Custom query methods (if needed) can be defined here
    List<ReviewRecord> findByReviewerId(Long projectId);
    List<ReviewRecord> findByCollaboration(Collaboration collaboration);
}