package org.example.groupbuying.user.repository;

import org.example.groupbuying.user.model.UserBasicLoginCheckDTO;
import org.example.groupbuying.user.model.UserBasicLoginReq;
import org.example.groupbuying.user.model.UserBasicLoginRes;
import org.example.groupbuying.user.model.UserBasicSignupReq;
import org.springframework.dao.EmptyResultDataAccessException;
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

    public UserBasicLoginRes findByEmailAndPassword(UserBasicLoginReq req) {
        UserBasicLoginCheckDTO dto = new UserBasicLoginCheckDTO();
        UserBasicLoginRes res;
        try {
            dto = jdbcTemplate.queryForObject("SELECT user_email,user_status FROM USER WHERE user_email = ? AND user_password = ?",
                    (rs,rowNum) -> {
                        UserBasicLoginCheckDTO dto1 = new UserBasicLoginCheckDTO(rs.getString("user_email"),
                                rs.getString("user_status"));
                        return dto1;
                    },
                    req.getUserEmail(),
                    req.getUserPassword());

           return res = new UserBasicLoginRes(true, 2500, "정상적으로 로그인 되었습니다.");
        }catch (EmptyResultDataAccessException e){
            return res = new UserBasicLoginRes(false,2501,"로그인에 실패했습니다.");
        }
    }
}
