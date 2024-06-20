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


    public String start(int gpbyIdx) {
        int result = gpbyRepository.updateStatus(gpbyIdx);
        if (result > 0) return "공구가 시작되었습니다.";
        else return "공구 상태 변경 실패";
    }

    public GpbyRegistRes regist(GpbyRegistReq gpbyRegistReq) {
        int result = gpbyRepository.save(gpbyRegistReq);
        if(result > 0) return new GpbyRegistRes(gpbyRegistReq.getGpbyTitle() + " 저장됨");
        else return new GpbyRegistRes(gpbyRegistReq.getGpbyTitle() + " 저장안됨");
    }


    public List<GpbyListRes> list() {
        return gpbyRepository.findAll();
    }
}
