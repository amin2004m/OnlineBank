package az.bank.onlineBank.services;

import az.bank.onlineBank.dto.UserDto;
import az.bank.onlineBank.entities.User;
import az.bank.onlineBank.exception.ServiceException;
import az.bank.onlineBank.repositories.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static az.bank.onlineBank.exceptionEnum.ErrorEnum.USER_ALREADY_EXCEPTION;
import static az.bank.onlineBank.exceptionEnum.ErrorEnum.USER_NOT_FOUND;


@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserService {

    UserRepository userRepository;
    ModelMapper modelMapper;

    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDto = users
                .stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
        return userDto;
    }

    public User register(User user) {

        Optional<User> existedUser = userRepository
                .findByUsername(user.getUsername());

        if (existedUser.isPresent()) {
            throw ServiceException
                    .of(USER_ALREADY_EXCEPTION);
        }
        return userRepository.save(user);
    }

    public User login(String username, String password) {
        return userRepository
                .findByUsernameAndPassword(username, password);
    }

    public Optional<User> findUserById(Long id) {
        Optional<User> findUser = userRepository
                .findById(id);
        if (findUser.isPresent()) {
            throw ServiceException
                    .of(USER_NOT_FOUND);
        }
        return userRepository.findById(id);
    }
}
//
//        List<UserDto> userDtoList = users.stream().map(
//                user -> {
//                    UserDto userDto = new UserDto();
//                    userDto.setUserId(user.getUserId());
//                    userDto.setUsername(user.getUsername());
//                    userDto.setAccount_id(user.getAccount().getId());
//                    userDto.setCreatedAt(user.getCreatedAt());
//                    return userDto;
//                }
//        ).toList();
//        return userDtoList;