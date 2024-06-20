package org.example.groupbuying.groupbuy;

import org.example.groupbuying.groupbuy.model.GpbyListRes;
import org.example.groupbuying.groupbuy.model.GpbyRegistReq;
import org.example.groupbuying.groupbuy.model.GpbyRegistRes;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GpbyService {
    private GpbyRepository gpbyRepository;

    public GpbyService(GpbyRepository gpbyRepository) {
        this.gpbyRepository = gpbyRepository;
    }

    public GpbyRegistRes regist(GpbyRegistReq gpbyRegistReq) {
        int result = gpbyRepository.save(gpbyRegistReq);
        if(result > 0) return new GpbyRegistRes("공구 idx: " + result + " 저장됨");
        else return new GpbyRegistRes(gpbyRegistReq.getGpbyTitle() + " 저장안됨");
    }


    public List<GpbyListRes> list() {
        return gpbyRepository.findAll();
    }
}
