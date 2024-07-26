package az.bank.onlineBank.controllers;

import az.bank.onlineBank.dto.UserDto;
import az.bank.onlineBank.entities.User;
import az.bank.onlineBank.services.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/users")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserController {

    UserService userService;

    @GetMapping
    public List<UserDto> getAllUsers() {
        List<UserDto> userDtoList = userService.getAllUsers();
        return userDtoList;
    }
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public User registerUser(@RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.CONTINUE)
    public User login(@RequestParam String username, @RequestParam String password) {
        return userService.login(username,password);
    }
    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Optional<User> findUserById(@RequestParam Long id){
       return userService.findUserById(id);
    }
}

