package org.example.groupbuying.bid;

import org.example.groupbuying.bid.model.BidRegistReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BidService {

    private BidRepository bidRepository;

    @Autowired
    public BidService(BidRepository bidRepository) {
        this.bidRepository = bidRepository;
    }

    public String bidRegist(BidRegistReq bidRegistReq) {
        Boolean registSuccess = bidRepository.bidRegist(bidRegistReq);
        if (registSuccess){
            return "입찰 등록에 성공하였습니다.";
        } else {
            return "입찰 등록에 실패하였습니다.";
        }
    }



}
