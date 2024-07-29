package az.bank.onlineBank.services;

import az.bank.onlineBank.dto.UserDto;
import az.bank.onlineBank.entities.User;
import az.bank.onlineBank.exception.ServiceException;
import az.bank.onlineBank.mapper.UserMapper;
import az.bank.onlineBank.repositories.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static az.bank.onlineBank.exceptionEnum.ErrorEnum.*;


@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserService {

    UserRepository userRepository;
    ModelMapper modelMapper;

    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users
                .stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    public User register(UserDto userDto) {
        Optional<User> existingUser = userRepository.findByUsername(userDto.getUsername());

        existingUser.ifPresentOrElse(
                user -> {
                    throw ServiceException.of(USER_ALREADY_EXCEPTION);
                },
                () -> {
                    User newUser = UserMapper.userToUserDTO(userDto);
                    userRepository.save(newUser);
                }
        );

        return userRepository.findByUsername(userDto.getUsername()).orElseThrow(() ->
                ServiceException.of(ERROR_CREATING_USER)
        );

        //TODO change this method logic to ifPresentOrElse


        //        Optional<User> existedUser = userRepository
//                .findByUsername(userDto.getUsername());
//
//        if (existedUser.isPresent()) {
//            throw ServiceException
//                    .of(USER_ALREADY_EXCEPTION);
//        }
    }

    public User login(String username, String password) {
        return userRepository
                .findByUsernameAndPassword(username, password)
                .orElseThrow(() -> ServiceException.of(USER_NOT_FOUND));
    }

    public User findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> ServiceException.of(USER_NOT_FOUND));
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

}