package cqu.mve.ResearchPlatformBackground.Message;

import cqu.mve.ResearchPlatformBackground.User.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * 表示一个用户给另一个用户发的私信
 */
@Entity
@Setter
@Getter
public final class Message {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private User sender;
    @ManyToOne
    private User receiver;
    private String content;
    private boolean isRead;

}
