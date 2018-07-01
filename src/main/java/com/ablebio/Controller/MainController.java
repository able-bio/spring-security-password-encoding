package com.ablebio.Controller;

import com.ablebio.DAO.UserDAO;
import com.ablebio.Model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private UserDetailsManager userDetailsManager;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/login")
    public String login(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout, Model model) {
        if (error != null) {
            model.addAttribute("error", "Wrong username or password!");
        }

        if (logout != null) {
            model.addAttribute("msg", "You have successfully logged out.");
        }
        return "login";
    }

    @RequestMapping("/register")
    public String test(Model model) {
        Users users = new Users();
        model.addAttribute("user", users);
        return "register";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String testPost(@Valid @ModelAttribute("user") Users user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "register";
        }
        String hashedPassword = passwordEncoder.encode(user.getPassword());

        Collection<? extends GrantedAuthority> roles = Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));

        UserDetails userDetails = new User(user.getUsername(), hashedPassword, roles);
        userDetailsManager.createUser(userDetails);
        return "registerSuccess";
    }
}
