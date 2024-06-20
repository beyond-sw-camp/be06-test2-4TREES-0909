package org.example.groupbuying.buisiness;

import org.example.groupbuying.buisiness.model.BuisinessReq;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BuisinessRepository {
    private JdbcTemplate jdbcTemplate;

    public BuisinessRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean save(BuisinessReq dto) {
        int a = jdbcTemplate.update("INSERT INTO COMPANY_INFO (com_info_name, com_info_address, com_info_type, com_info_intro,company_idx) VALUE (?,? ,?,?,?)",
                dto.getComInfoName(),
                dto.getComInfoAddress(),
                dto.getComInfoType(),
                dto.getComInfoIntro(),
                dto.getComInfoIdx()
        );
        if (a == 1) {
            return true;
        } else {
            return false;
        }
    }
}
