package az.bank.OnlineBank.controllers;

import az.bank.OnlineBank.entities.User;
import az.bank.OnlineBank.services.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class UserController {

    UserService services;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return services.register(user);
    }

    @PostMapping("/login")
    public User login(@RequestParam String username, @RequestParam(required = false) Long userId, @RequestParam String password) {
        return services.login(username, password);
    }
}

