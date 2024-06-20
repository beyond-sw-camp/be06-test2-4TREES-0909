package org.example.groupbuying.groupbuy;


import com.sun.jna.platform.win32.OaIdl;
import org.example.groupbuying.groupbuy.model.GpbyListRes;
import org.example.groupbuying.groupbuy.model.GpbyRegistReq;
import org.example.groupbuying.groupbuy.model.GpbyRegistRes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/gpby")
public class GpbyController {
    private GpbyService gpbyService;

    public GpbyController(GpbyService gpbyService) {
        this.gpbyService = gpbyService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/regist")
    public ResponseEntity<GpbyRegistRes> regist(@RequestBody GpbyRegistReq gpbyRegistReq) {
        return ResponseEntity.ok(gpbyService.regist(gpbyRegistReq));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public ResponseEntity<List<GpbyListRes>> list() {
        return ResponseEntity.ok(gpbyService.list());
    }
}
