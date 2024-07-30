package az.bank.onlineBank.services;

import az.bank.onlineBank.dto.UserRequest;
import az.bank.onlineBank.dto.UserResponse;
import az.bank.onlineBank.entities.User;
import az.bank.onlineBank.exception.ServiceException;
import az.bank.onlineBank.mapper.UserMapper;
import az.bank.onlineBank.repositories.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static az.bank.onlineBank.exceptionEnum.ErrorEnum.*;
import static az.bank.onlineBank.mapper.UserMapper.mapToUserEntity;
import static az.bank.onlineBank.mapper.UserMapper.mapToUserResponse;


@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserService {

    UserRepository userRepository;

    public List<UserResponse> getAllUsers() {
        var userList = userRepository.findAll();
        return userList.stream().map(UserMapper::mapToUserResponse).collect(Collectors.toList());
    }

    public UserResponse register(UserRequest userRequest) {
       userRepository.findByUsername(userRequest.getUsername())
               .ifPresentOrElse(
                user -> {
                    throw ServiceException.of(USER_ALREADY_EXCEPTION);
                },
                () -> {
                    User newUser = UserMapper.mapToUserEntity(userRequest);
                    userRepository.save(newUser);
                }
        );

        var user = userRepository.findByUsername(userRequest.getUsername())
                .orElseThrow(() -> ServiceException.of(ERROR_CREATING_USER));

        return mapToUserResponse(user);

    }

    public UserResponse login(String username, String password) {
         var user = userRepository.findByUsernameAndPassword(username,password)
                .orElseThrow(() -> ServiceException.of(USER_NOT_FOUND));
         return mapToUserResponse(user);
    }

    public UserResponse findUserById(Long id) {
        var user =  userRepository.findById(id)
                .orElseThrow(() -> ServiceException.of(USER_NOT_FOUND));
        return mapToUserResponse(user);
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