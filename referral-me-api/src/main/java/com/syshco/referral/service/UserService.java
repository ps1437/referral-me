package com.syshco.referral.service;

import com.syshco.referral.exception.NotFoundException;
import com.syshco.referral.entity.User;
import com.syshco.referral.mapper.UserMapper;
import com.syshco.referral.model.UserModel;
import com.syshco.referral.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserModel> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toUserModel)
                .toList();
    }

    public UserModel getUserById(Long id) {
        var user = findById(id);
        return userMapper.toUserModel(user);
    }

    public UserModel createUser(UserModel userModel) {
        var user = userMapper.toUser(userModel);
        user = userRepository.save(user);
        return userMapper.toUserModel(user);
    }

    public UserModel updateUser(Long id, UserModel userModel) {
        var existingUser = findById(id);

        var user = userMapper.toUser(userModel);
        user.setId(existingUser.getId());
        user = userRepository.save(user);
        return userMapper.toUserModel(user);
    }

    private User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found with id:" + id));
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
