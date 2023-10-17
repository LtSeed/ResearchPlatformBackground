package cqu.mve.ResearchPlatformBackground.User;

import cqu.mve.ResearchPlatformBackground.User.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User createUser(String username, String rawPassword) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(rawPassword));
        // 设置角色和其他属性

        return userRepository.save(user);
    }

    // 其他可能的方法，如 updateUser, deleteUser 等
}
