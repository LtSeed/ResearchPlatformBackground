package cqu.mve.ResearchPlatformBackground.Message;

import cqu.mve.ResearchPlatformBackground.User.Repo.UserRepository;
import cqu.mve.ResearchPlatformBackground.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/messages")
public class MessageController {
    @Autowired
    private MessageService messageService;
    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<Message> createMessage(@RequestBody Message message) {
        return ResponseEntity.ok(messageService.saveMessage(message));
    }


    @GetMapping("/sender/{senderId}")
    public ResponseEntity<List<Message>> getMessagesBySender(@PathVariable Long senderId) {
        Optional<User> byId = userRepository.findById(senderId);
        if(byId.isEmpty()){
            return ResponseEntity.unprocessableEntity().build();
        }
        User sender = byId.get();
        sender.setId(senderId);
        return ResponseEntity.ok(messageService.getMessagesBySender(sender));
    }

    @GetMapping("/receiver/{receiverId}")
    public ResponseEntity<List<Message>> getMessagesByReceiver(@PathVariable Long receiverId) {
        Optional<User> byId = userRepository.findById(receiverId);
        if(byId.isEmpty()){
            return ResponseEntity.unprocessableEntity().build();
        }
        User receiver = byId.get();
        receiver.setId(receiverId);
        return ResponseEntity.ok(messageService.getMessagesByReceiver(receiver));
    }

    @GetMapping("/unread/{receiverId}")
    public ResponseEntity<List<Message>> getUnreadMessages(@PathVariable Long receiverId) {
        User receiver = new User();
        receiver.setId(receiverId);
        return ResponseEntity.ok(messageService.getUnreadMessages(receiver));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Message> getMessageById(@PathVariable Long id) {
        Optional<Message> message = messageService.getMessageById(id);
        return message.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable Long id) {
        messageService.deleteMessage(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Message> setMessageRead(@PathVariable Long id) {
        Optional<Message> message = messageService.getMessageById(id);
        if(message.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Message message1 = message.get();
        message1.setRead(true);
        messageService.saveMessage(message1);
        return ResponseEntity.ok().build();
    }
}

   
