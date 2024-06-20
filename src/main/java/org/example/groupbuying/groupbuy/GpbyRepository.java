package org.example.groupbuying.groupbuy;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class GpbyRepository {
    private JdbcTemplate jdbcTemplate;

    public GpbyRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int updateStatus(int gpbyIdx) {
        return jdbcTemplate.update("UPDATE GROUP_BUY SET gpby_status = '진행' WHERE gpby_idx = ?", gpbyIdx);
    }
}
