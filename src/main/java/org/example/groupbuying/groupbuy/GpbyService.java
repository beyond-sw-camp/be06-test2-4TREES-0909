package org.example.groupbuying.groupbuy;

import org.springframework.stereotype.Service;

@Service
public class GpbyService {
    private GpbyRepository gpbyRepository;

    public GpbyService(GpbyRepository gpbyRepository) {
        this.gpbyRepository = gpbyRepository;
    }

    public String start(int gpbyIdx) {
        int result = gpbyRepository.updateStatus(gpbyIdx);
        if(result > 0) return "공구가 시작되었습니다.";
        else return "공구 상태 변경 실패";
    }
}
