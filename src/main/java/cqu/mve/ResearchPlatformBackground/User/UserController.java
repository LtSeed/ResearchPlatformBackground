package cqu.mve.ResearchPlatformBackground.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public ModelAndView registrationForm(Model model) {
        model.addAttribute("user", new User());
        System.out.println("G");
        return new ModelAndView("register"); // 返回注册页面视图
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") User user) {
        userService.createUser(user.getUsername(), user.getPassword());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        return "redirect:/user/login"; // 重定向到登录页面
    }

    @GetMapping("/login")
    public ModelAndView loginForm() {
        System.out.println("GET LOGIN");
        UserDetails test2 = userDetailsService.loadUserByUsername("test2");
        String password = test2.getPassword();
        System.out.println(passwordEncoder.matches("test2",password));
        return new ModelAndView("login"); // 返回登录页面视图
    }


    // 其他可能的端点，如 "/profile", "/update", "/delete" 等
}