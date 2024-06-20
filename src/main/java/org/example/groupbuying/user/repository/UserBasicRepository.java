package org.example.groupbuying.user.repository;

import org.example.groupbuying.user.model.UserBasicSignupReq;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserBasicRepository {

    private JdbcTemplate jdbcTemplate;

    public UserBasicRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int save(UserBasicSignupReq req) {
        int res = jdbcTemplate.update("INSERT INTO USER (user_type, user_name, user_email, user_password, user_phone_number, user_birth," +
                "user_sex)VALUES (?,?,?,?,?,?,?)",
                req.getUserType(),
                req.getUserName(),
                req.getUserEmail(),
                req.getUserPassword(),
                req.getUserPhoneNumber(),
                req.getUserBirth(),
                req.getUserSex());
        return res;

    }
}
