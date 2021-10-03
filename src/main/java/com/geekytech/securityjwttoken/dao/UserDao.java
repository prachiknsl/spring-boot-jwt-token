package com.geekytech.securityjwttoken.dao;

import com.geekytech.securityjwttoken.model.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<UserDetail, Long> {
    UserDetail findByUsername(String username);
}
