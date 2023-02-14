package org.example.unittest.springh2test.dao;

import org.example.unittest.springh2test.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author WuJi
 **/
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
