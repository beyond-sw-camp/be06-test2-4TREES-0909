package org.example.groupbuying.bid;

import org.example.groupbuying.bid.model.BidRegistReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BidRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BidRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Boolean bidRegist(BidRegistReq bidRegistReq) {
        String registSQL = "INSERT INTO BID (product_idx, gpby_idx, bid_price) VALUES (?, ?, ?)";
        int registSuccess = jdbcTemplate.update(registSQL, bidRegistReq.getProductIdx(), bidRegistReq.getGpbyIdx(), bidRegistReq.getBidPrice());
        return registSuccess > 0;
    }
}
