package cqu.mve.ResearchPlatformBackground.User;

import cqu.mve.ResearchPlatformBackground.Message.MessageReceiver;
import cqu.mve.ResearchPlatformBackground.Message.MessageSender;
import cqu.mve.ResearchPlatformBackground.Records.Message;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;


// User Account Management.
@Entity
@Setter
@Getter
public class User implements MessageReceiver, MessageSender {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String password;
    private String major;
    private String researchInterest;


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;

    @Override
    public void receiveMessage(Message message) {

    }

    @Override
    public void sendMessage(Message message) {

    }
}
