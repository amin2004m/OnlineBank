package az.bank.onlineBank.controllers;

import az.bank.onlineBank.dto.UserDto;
import az.bank.onlineBank.entities.User;
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
    public List<UserDto> getAllUsers() {
        List<UserDto> userDtoList = userService.getAllUsers();
        return userDtoList;
    }
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public User registerUser(@RequestBody UserDto user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.CONTINUE)
    public User login(@RequestParam String username, @RequestParam String password) {
        return userService.login(username,password);
    }
    @GetMapping("id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public User findUserById(@RequestParam Long id){
       return userService.findUserById(id);
    }
}

