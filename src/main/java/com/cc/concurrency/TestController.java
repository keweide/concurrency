package com.cc.concurrency;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by think on 2018.05.16.
 */
@Controller
public class TestController {

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return "test";
    }
}
