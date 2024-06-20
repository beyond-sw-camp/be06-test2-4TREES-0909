package org.example.groupbuying.bid;

import org.example.groupbuying.bid.model.BidRegistReq;
import org.example.groupbuying.bid.model.BidSelectReq;
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
    public Boolean bidSelect(BidSelectReq bidSelectReq) {
        String gpbyStatusUpdateSQL = "UPDATE GROUP_BUY SET gpby_status='진행' WHERE gpby_idx = ?";
        String bidSelectUpdateSQL = "UPDATE BID SET bid_select='1' WHERE bid_idx = ?";
        int gpbyStatusUpdateSuccess = jdbcTemplate.update(gpbyStatusUpdateSQL, bidSelectReq.getGpbyIdx());
        int bidSelectUpdateSuccess = jdbcTemplate.update(bidSelectUpdateSQL, bidSelectReq.getBidIdx());
        return gpbyStatusUpdateSuccess > 0 && bidSelectUpdateSuccess > 0;
    }
}
