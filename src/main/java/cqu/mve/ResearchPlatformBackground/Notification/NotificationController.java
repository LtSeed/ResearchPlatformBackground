package cqu.mve.ResearchPlatformBackground.Notification;

import cqu.mve.ResearchPlatformBackground.User.Permission.Admin;
import cqu.mve.ResearchPlatformBackground.User.Repo.AdminRepository;
import cqu.mve.ResearchPlatformBackground.User.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notifications")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;
    @Autowired
    private AdminRepository adminRepository;

    @PostMapping
    public ResponseEntity<Notification> createNotification(@RequestBody Notification notification) {
        return ResponseEntity.ok(notificationService.saveNotification(notification));
    }

    @GetMapping("/admin/{adminId}")
    public ResponseEntity<List<Notification>> getNotificationsByAdmin(@PathVariable Long adminId) {
        Optional<Admin> byId = adminRepository.findById(adminId);
        if(byId.isEmpty()) return ResponseEntity.notFound().build();
        Admin admin = byId.get();
        return ResponseEntity.ok(notificationService.getNotificationsByAdmin(admin));
    }

    @GetMapping("/recent/{day}")
    public ResponseEntity<List<Notification>> getRecentNotifications(@PathVariable Long day) {
        LocalDateTime recentTimestamp = LocalDateTime.now().minusDays(day);  // 获取过去day天的通知
        return ResponseEntity.ok(notificationService.getRecentNotifications(recentTimestamp));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notification> getNotificationById(@PathVariable Long id) {
        Optional<Notification> notification = notificationService.getNotificationById(id);
        return notification.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotification(@PathVariable Long id) {
        notificationService.deleteNotification(id);
        return ResponseEntity.noContent().build();
    }
}
