package cqu.mve.ResearchPlatformBackground.User.Permission;

import cqu.mve.ResearchPlatformBackground.Notification.Notification;
import cqu.mve.ResearchPlatformBackground.Project.Collaboration.Collaboration;
import cqu.mve.ResearchPlatformBackground.Review.ReviewRecord;
import cqu.mve.ResearchPlatformBackground.Review.Reviewer;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

@Entity
public class Admin extends Inspector {

    @ManyToMany
    List<Notification> releasedNotifications;

    @Override
    public Long getUserId() {
        return getId();
    }

}
