package org.example.unittest.springh2test.service;

import lombok.RequiredArgsConstructor;
import org.example.unittest.springh2test.dao.UserRepository;
import org.example.unittest.springh2test.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author WuJi
 **/
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {
    private final UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
