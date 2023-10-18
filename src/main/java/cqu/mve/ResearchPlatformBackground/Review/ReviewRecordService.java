package cqu.mve.ResearchPlatformBackground.Review;

import cqu.mve.ResearchPlatformBackground.Project.Collaboration.Collaboration;
import cqu.mve.ResearchPlatformBackground.Review.Repo.ReviewRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewRecordService {
    @Autowired
    private ReviewRecordRepository reviewRecordRepository;

    public ReviewRecord saveReviewRecord(ReviewRecord reviewRecord) {
        return reviewRecordRepository.save(reviewRecord);
    }

    public List<ReviewRecord> getReviewRecordsByReviewerId(Long reviewerId) {
        return reviewRecordRepository.findByReviewerId(reviewerId);
    }

    public List<ReviewRecord> getReviewRecordsByCollaboration(Collaboration collaboration) {
        return reviewRecordRepository.findByCollaboration(collaboration);
    }

    public Optional<ReviewRecord> getReviewRecordById(Long id) {
        return reviewRecordRepository.findById(id);
    }

    public void deleteReviewRecord(Long id) {
        reviewRecordRepository.deleteById(id);
    }
}

