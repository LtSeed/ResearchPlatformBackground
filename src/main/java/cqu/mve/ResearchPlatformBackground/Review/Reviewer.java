package cqu.mve.ResearchPlatformBackground.Review;

import cqu.mve.ResearchPlatformBackground.Project.Collaboration.Collaboration;

public interface Reviewer {
    ReviewRecord review(Collaboration collaboration);
    Long getUserId();
}
