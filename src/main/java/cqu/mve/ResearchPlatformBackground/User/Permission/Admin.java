package cqu.mve.ResearchPlatformBackground.User.Permission;

import cqu.mve.ResearchPlatformBackground.Records.ReviewRecord;
import cqu.mve.ResearchPlatformBackground.Review.Reviewable;
import cqu.mve.ResearchPlatformBackground.Review.Reviewer;
import cqu.mve.ResearchPlatformBackground.User.User;

public class Admin extends User implements Reviewer {


    @Override
    public ReviewRecord review(Reviewable reviewable) {
        return null;
    }
}
