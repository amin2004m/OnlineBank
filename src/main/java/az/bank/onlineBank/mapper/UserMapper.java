package az.bank.onlineBank.mapper;

import az.bank.onlineBank.dto.UserRequest;
import az.bank.onlineBank.dto.UserResponse;
import az.bank.onlineBank.entities.Account;
import az.bank.onlineBank.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Set;


@Component
@RequiredArgsConstructor
public class UserMapper {

    public static User mapToUserEntity(UserRequest userRequest) {

        Account account = new Account();

        User user = User.builder()
                .userID(userRequest.getUserId())
                .username(userRequest.getUsername())
                .password(userRequest.getPassword())
                .updatedAt(LocalDateTime.now())
                .isActive(userRequest.getIsActive())
                .build();

//        Set<Account> accountList = user.getAccounts();
//        accountList.add(account);

        return user;
    }

    public static UserResponse mapToUserResponse(User user) {
        return UserResponse.builder()
                .id(user.getUserID())
                .username(user.getUsername())
                .password(user.getPassword())
                .createdAt(user.getCreatedAt())
                .build();
    }

}
