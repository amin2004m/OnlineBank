package az.bank.onlineBank.controllers;

import az.bank.onlineBank.dto.UserRequest;
import az.bank.onlineBank.dto.UserResponse;
import az.bank.onlineBank.services.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/users")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserController {

    UserService userService;

    @GetMapping
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers();

    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse registerUser(@RequestBody UserRequest user) {

        UserResponse userResponse = userService.register(user);

        return userResponse;
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse login(@RequestParam String username, @RequestParam String password) {
        return userService.login(username, password);
    }

    @GetMapping("id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public UserResponse findUserById(@PathVariable Long id) {
        return userService.findUserById(id);
    }
}

