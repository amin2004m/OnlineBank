package az.bank.OnlineBank.services;

import az.bank.OnlineBank.entities.User;
import az.bank.OnlineBank.repositories.UserRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
public class UserService {

   UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register(User user) {
        return userRepository.save(user);
    }


    public User login(String username, String password) {
        return userRepository.findByUsername(username);
    }
}
