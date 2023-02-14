package org.example.unittest.springh2test.service;

import org.example.unittest.springh2test.entity.User;

import java.util.List;

/**
 * @author WuJi
 **/

public interface IUserService {
    List<User> findAll();
}
