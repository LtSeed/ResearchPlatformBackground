package cqu.mve.ResearchPlatformBackground.Review;

import cqu.mve.ResearchPlatformBackground.Project.Collaboration.Collaboration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/review-records")
public class ReviewRecordController {
    @Autowired
    private ReviewRecordService reviewRecordService;

    @PostMapping
    public ResponseEntity<ReviewRecord> createReviewRecord(@RequestBody ReviewRecord reviewRecord) {
        return ResponseEntity.ok(reviewRecordService.saveReviewRecord(reviewRecord));
    }

    @GetMapping("/reviewer/{reviewerId}")
    public ResponseEntity<List<ReviewRecord>> getReviewRecordsByReviewerId(@PathVariable Long reviewerId) {
        return ResponseEntity.ok(reviewRecordService.getReviewRecordsByReviewerId(reviewerId));
    }

    @GetMapping("/collaboration/{collaborationId}")
    public ResponseEntity<List<ReviewRecord>> getReviewRecordsByCollaboration(@PathVariable Long collaborationId) {
        Collaboration collaboration = new Collaboration();
        collaboration.setId(collaborationId);
        return ResponseEntity.ok(reviewRecordService.getReviewRecordsByCollaboration(collaboration));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewRecord> getReviewRecordById(@PathVariable Long id) {
        Optional<ReviewRecord> reviewRecord = reviewRecordService.getReviewRecordById(id);
        return reviewRecord.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReviewRecord(@PathVariable Long id) {
        reviewRecordService.deleteReviewRecord(id);
        return ResponseEntity.noContent().build();
    }
}
