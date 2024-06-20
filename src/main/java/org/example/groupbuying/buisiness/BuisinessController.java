package org.example.groupbuying.buisiness;

import org.example.groupbuying.buisiness.model.BuisinessReq;
import org.example.groupbuying.buisiness.model.BuisinessRes;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/company")
public class BuisinessController {

    private BuisinessService buisinessService;

    public BuisinessController(BuisinessService buisinessService) {
        this.buisinessService = buisinessService;
    }

    //ResponseEntity<T> = 사용자의 HttpRequest에 대한 응답 데이터를 포함하는 클래스
@RequestMapping(method = RequestMethod.POST, value = "/regist")
public ResponseEntity<String >regist (@RequestBody BuisinessReq buisinessReq){
String registResult =buisinessService.companyRegist(buisinessReq);
return ResponseEntity.ok(registResult);
}

}
