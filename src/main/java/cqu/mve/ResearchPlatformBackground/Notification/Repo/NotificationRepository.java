package cqu.mve.ResearchPlatformBackground.Notification.Repo;

import cqu.mve.ResearchPlatformBackground.Notification.Notification;
import cqu.mve.ResearchPlatformBackground.User.Permission.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByAdmin(Admin admin);
    List<Notification> findByTimestampAfter(LocalDateTime timestamp);
}
