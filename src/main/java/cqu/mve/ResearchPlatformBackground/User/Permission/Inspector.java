package cqu.mve.ResearchPlatformBackground.User.Permission;

import cqu.mve.ResearchPlatformBackground.Project.Collaboration.Collaboration;
import cqu.mve.ResearchPlatformBackground.Review.ReviewRecord;
import cqu.mve.ResearchPlatformBackground.Review.Reviewer;
import cqu.mve.ResearchPlatformBackground.User.User;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

@Entity
public class Inspector extends User implements Reviewer {

    @ManyToMany
    private List<Collaboration> reviewedCollaborations;

    @Override
    public ReviewRecord review(Collaboration collaboration) {
        return null;
    }

    public List<Collaboration> getReviewedCollaborations() {
        return reviewedCollaborations;
    }

    @Override
    public Long getUserId() {
        return getId();
    }
}
