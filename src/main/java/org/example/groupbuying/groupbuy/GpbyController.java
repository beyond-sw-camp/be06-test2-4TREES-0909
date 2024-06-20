package org.example.groupbuying.groupbuy;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gpby")
public class GpbyController {
    private GpbyService gpbyService;

    public GpbyController(GpbyService gpbyService) {
        this.gpbyService = gpbyService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/start")
    public String start(int gpbyIdx) {
        return gpbyService.start(gpbyIdx);
    }
}
