package org.example.groupbuying.buisiness;

//컨트롤러 > 서비스 > 레포 > 디비

import org.example.groupbuying.buisiness.model.BuisinessReq;
import org.example.groupbuying.buisiness.model.BuisinessRes;
import org.springframework.stereotype.Service;

import static org.apache.coyote.http11.Constants.a;

@Service
public class BuisinessService {
    private BuisinessRepository buisinessRepository;

    public BuisinessService(BuisinessRepository buisinessRepository) {
        this.buisinessRepository = buisinessRepository;
    }

    // 업체 등록 메서드
    public String companyRegist(BuisinessReq buisinessReq) {
        String a;
        boolean result = buisinessRepository.save(buisinessReq);
        if (result == true) {
            return "업체등록에 성공했습니다";
        } else {
            return "업체등록에 실패했습니다.";
        }
    }
}
