package cqu.mve.ResearchPlatformBackground.User.Permission;

import cqu.mve.ResearchPlatformBackground.Project.Collaboration.Collaboration;
import cqu.mve.ResearchPlatformBackground.Review.ReviewRecord;
import cqu.mve.ResearchPlatformBackground.Review.Reviewer;
import org.springframework.security.core.GrantedAuthority;

public class Admin extends Inspector {





    @Override
    public Long getUserId() {
        return getId();
    }

}
