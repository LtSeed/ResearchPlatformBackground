package cqu.mve.ResearchPlatformBackground.Message;

import cqu.mve.ResearchPlatformBackground.Message.Repo.MessageRepository;
import cqu.mve.ResearchPlatformBackground.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public Message saveMessage(Message message) {
        return messageRepository.save(message);
    }

    public List<Message> getMessagesBySender(User sender) {
        return messageRepository.findBySender(sender);
    }

    public List<Message> getMessagesByReceiver(User receiver) {
        return messageRepository.findByReceiver(receiver);
    }

    public Optional<Message> getMessageById(Long id) {
        return messageRepository.findById(id);
    }

    public void deleteMessage(Long id) {
        messageRepository.deleteById(id);
    }

    public List<Message> getUnreadMessages(User receiver) {
        return messageRepository.findByReceiverAndReadIsFalse(receiver);
    }
}
