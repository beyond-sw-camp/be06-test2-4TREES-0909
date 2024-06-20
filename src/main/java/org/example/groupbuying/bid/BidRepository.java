package org.example.groupbuying.bid;

import org.example.groupbuying.bid.model.BidIdxReq;
import org.example.groupbuying.bid.model.BidRegistReq;
import org.example.groupbuying.bid.model.BidSelectReq;
import org.example.groupbuying.bid.model.BidWaitRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    public List<BidWaitRes> bidWaitList(){
        String waitListSQL = "SELECT * FROM GROUP_BUY WHERE gpby_status='입찰 대기'";
        List<BidWaitRes> waitResList = jdbcTemplate.query(waitListSQL,
                (rs, rowNum) -> new BidWaitRes(rs.getInt("gpby_idx"), rs.getString("gpby_title"),
                        rs.getInt("gpby_quantity"))
        );

        return waitResList;
    }

    public Boolean bidCancel(BidIdxReq bidIdxReq) {
        String bidCancelSQL = "UPDATE BID SET bid_status='삭제' WHERE bid_idx = ?";
        int bidCancelSuccess = jdbcTemplate.update(bidCancelSQL, bidIdxReq.getBidIdx());
        return bidCancelSuccess > 0;
    }
}