package org.example.groupbuying.groupbuy;

import org.example.groupbuying.groupbuy.model.GpbyListRes;
import org.example.groupbuying.groupbuy.model.GpbyRegistReq;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class GpbyRepository {
    private JdbcTemplate jdbcTemplate;

    public GpbyRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public int updateStatus(int gpbyIdx) {
        return jdbcTemplate.update("UPDATE GROUP_BUY SET gpby_status = '진행' WHERE gpby_idx = ?", gpbyIdx);

    public int save(GpbyRegistReq gpbyRegistReq) {
        return jdbcTemplate.update("INSERT INTO GROUP_BUY " +
                        "(user_idx, category_idx, gpby_title, gpby_content,gpby_quantity, gpby_bid_enddate) " +
                        "VALUES (?, ?, ?,?,?,DATE_ADD(CURRENT_TIMESTAMP, INTERVAL ? DAY))",
                1,
                gpbyRegistReq.getCategoryIdx(),
                gpbyRegistReq.getGpbyTitle(),
                gpbyRegistReq.getGpbyContent(),
                gpbyRegistReq.getGpbyQuantity(),
                gpbyRegistReq.getGpbyEnddate()
        );
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
