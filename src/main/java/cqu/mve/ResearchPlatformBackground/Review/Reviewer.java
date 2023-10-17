package cqu.mve.ResearchPlatformBackground.Review;

import cqu.mve.ResearchPlatformBackground.Records.ReviewRecord;

public interface Reviewer {
    ReviewRecord review(Reviewable reviewable);
}
