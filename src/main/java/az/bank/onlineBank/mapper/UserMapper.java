package az.bank.onlineBank.mapper;

import az.bank.onlineBank.dto.UserDto;
import az.bank.onlineBank.entities.User;


public class UserMapper {

    public static User userToUserDTO(UserDto userDto){
        User user = new User();
        user.setUserID(userDto.getUserId());
        user.setUsername(userDto.getUsername());
        user.setCreatedAt(userDto.getCreatedAt());
        user.setUpdatedAt(userDto.getCreatedAt());
        user.setAccount(user.getAccount());

        return user;
    }
}
