package org.example.groupbuying.user.controller;

import org.example.groupbuying.user.model.UserBasicLoginReq;
import org.example.groupbuying.user.model.UserBasicLoginRes;
import org.example.groupbuying.user.model.UserBasicSignupReq;
import org.example.groupbuying.user.service.UserBasicService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/basic")
public class UserBasicController {

    private final UserBasicService userBasicService;

    public UserBasicController(UserBasicService userBasicService) {
        this.userBasicService = userBasicService;
    }

    @PostMapping(value = "/signup")
    public ResponseEntity<String> signup(
            @RequestBody UserBasicSignupReq req
    ){
        String res = userBasicService.signup(req);

        return ResponseEntity.ok(res);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<UserBasicLoginRes> login(
            @RequestBody UserBasicLoginReq req
    ){
        UserBasicLoginRes res = userBasicService.login(req);

        return ResponseEntity.ok(res);
    }
}
