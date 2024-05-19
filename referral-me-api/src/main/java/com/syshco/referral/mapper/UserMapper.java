package com.syshco.referral.mapper;

import com.syshco.referral.entity.User;
import com.syshco.referral.model.UserEntity;
import com.syshco.referral.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface UserMapper {

    UserModel toUserModel(User userEntity);

    User toUser(UserModel userModel);
}
