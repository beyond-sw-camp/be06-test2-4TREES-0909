package org.example.groupbuying.bid;

import org.example.groupbuying.bid.model.BidRegistReq;
import org.example.groupbuying.bid.model.BidSelectReq;
import org.example.groupbuying.bid.model.BidWaitRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bid")
public class BidController {

    private BidService bidService;

    @Autowired
    public BidController(BidService bidService) {
        this.bidService = bidService;
    }

    @RequestMapping(method = RequestMethod.POST, value="/regist")
    public ResponseEntity<String> BidRegist(@RequestBody BidRegistReq bidRegistReq){
        String result = bidService.bidRegist(bidRegistReq);
        return ResponseEntity.ok(result);
    }

    @RequestMapping(method = RequestMethod.POST, value="/select")
    public ResponseEntity<String> BidRegist(@RequestBody BidSelectReq bidSelectReq){
        String result = bidService.bidSelect(bidSelectReq);
        return ResponseEntity.ok(result);
    }

    @RequestMapping(method = RequestMethod.GET, value="/list")
    public ResponseEntity<List<BidWaitRes>> BidWaitList(){
        List<BidWaitRes> bidWaitResList = bidService.bidWaitResList();
        return ResponseEntity.ok(bidWaitResList);
    }

}
