package org.example.groupbuying.bid;

import org.example.groupbuying.bid.model.BidRegistReq;
import org.example.groupbuying.bid.model.BidSelectReq;
import org.example.groupbuying.bid.model.BidWaitRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public String bidSelect(BidSelectReq bidSelectReq) {
        Boolean bidSelectSuccess = bidRepository.bidSelect(bidSelectReq);
        if (bidSelectSuccess){
            return "입찰 선택이 완료되었습니다.";
        } else {
            return "입찰 선택에 실패하였습니다.";
        }
    }

    public List<BidWaitRes> bidWaitResList(){
        List<BidWaitRes> bidWaitResList = bidRepository.bidWaitList();
        return bidWaitResList;
    }



}
