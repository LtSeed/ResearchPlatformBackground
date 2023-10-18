package cqu.mve.ResearchPlatformBackground.Message.Repo;

import cqu.mve.ResearchPlatformBackground.Message.Message;
import cqu.mve.ResearchPlatformBackground.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findBySender(User sender);
    List<Message> findByReceiver(User receiver);

    List<Message> findByReceiverAndReadIsFalse(User receiver);
}
