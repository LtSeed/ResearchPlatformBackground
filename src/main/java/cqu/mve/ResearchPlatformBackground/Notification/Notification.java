package cqu.mve.ResearchPlatformBackground.Notification;

import cqu.mve.ResearchPlatformBackground.User.Permission.Admin;
import cqu.mve.ResearchPlatformBackground.User.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 表示一个通知
 */
@Entity
@Getter
@Setter
public class Notification {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Admin admin;
    private String content;
    private LocalDateTime timestamp;

    // ...其他必要的方法，如构造函数、equals、hashCode等
}
