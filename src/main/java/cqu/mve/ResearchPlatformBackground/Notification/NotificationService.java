package cqu.mve.ResearchPlatformBackground.Notification;

import cqu.mve.ResearchPlatformBackground.Notification.Repo.NotificationRepository;
import cqu.mve.ResearchPlatformBackground.User.Permission.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Queue;

// Notification System
@Service
public class NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;

    public Notification saveNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    public List<Notification> getNotificationsByAdmin(Admin admin) {
        return notificationRepository.findByAdmin(admin);
    }

    public List<Notification> getRecentNotifications(LocalDateTime timestamp) {
        return notificationRepository.findByTimestampAfter(timestamp);
    }

    public Optional<Notification> getNotificationById(Long id) {
        return notificationRepository.findById(id);
    }

    public void deleteNotification(Long id) {
        notificationRepository.deleteById(id);
    }
}
