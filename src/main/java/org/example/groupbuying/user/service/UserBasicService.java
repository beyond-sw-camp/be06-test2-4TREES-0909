package org.example.groupbuying.user.service;

import org.example.groupbuying.user.model.UserBasicSignupReq;
import org.example.groupbuying.user.repository.UserBasicRepository;
import org.springframework.stereotype.Service;

@Service
public class UserBasicService {

    private final UserBasicRepository userBasicRepository;

    public UserBasicService(UserBasicRepository userBasicRepository) {
        this.userBasicRepository = userBasicRepository;
    }

    public String signup(UserBasicSignupReq req) {
        int res = userBasicRepository.save(req);
        if (res > 0){
            return "회원 가입 성공";
        }else {
            return "회원 가입 실패";
        }
    }
}
