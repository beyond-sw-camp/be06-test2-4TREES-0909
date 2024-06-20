package org.example.groupbuying.groupbuy;

import org.example.groupbuying.groupbuy.model.GpbyListRes;
import org.example.groupbuying.groupbuy.model.GpbyRegistReq;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;


@Repository
public class GpbyRepository {
    private JdbcTemplate jdbcTemplate;

    public GpbyRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public int updateStatus(int gpbyIdx) {
        return jdbcTemplate.update("UPDATE GROUP_BUY SET gpby_status = '진행' WHERE gpby_idx = ?", gpbyIdx);
    }

    public int save(GpbyRegistReq gpbyRegistReq) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        String sql = "INSERT INTO GROUP_BUY " +
                "(user_idx, category_idx, gpby_title, gpby_content, gpby_quantity, gpby_bid_enddate) " +
                "VALUES (?, ?, ?, ?, ?, DATE_ADD(CURRENT_TIMESTAMP, INTERVAL ? DAY))";

        try {
            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, 1);
                ps.setInt(2, gpbyRegistReq.getCategoryIdx());
                ps.setString(3, gpbyRegistReq.getGpbyTitle());
                ps.setString(4, gpbyRegistReq.getGpbyContent());
                ps.setInt(5, gpbyRegistReq.getGpbyQuantity());
                ps.setInt(6, gpbyRegistReq.getGpbyEnddate());
                return ps;
            }, keyHolder);

            return keyHolder.getKey().intValue(); // This will return the generated gpbyIdx value
        } catch (DataAccessException e) {
            // Log the exception (optional)
            e.printStackTrace();
            return -1; // Indicate failure with a specific value
        }
    }

    public List<GpbyListRes> findAll() {
        List<GpbyListRes> gpbyListRes = jdbcTemplate.query("SELECT gpby_idx, gpby_title, gpby_quantity from GROUP_BUY",
                // 실행 결과를 DTO로 옮기는 코드 (익명함수, 람다식)
                (rs, rowNum) -> {
                    GpbyListRes response = new GpbyListRes(rs.getInt("gpby_idx"), rs.getString("gpby_title"), rs.getInt("gpby_quantity"));
                    return response;
                }
        );
        return gpbyListRes;

    }
}
