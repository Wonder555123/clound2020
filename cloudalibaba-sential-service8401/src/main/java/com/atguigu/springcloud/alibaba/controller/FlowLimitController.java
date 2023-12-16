package com.atguigu.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA(){
        return "testA";
    }

    @GetMapping("/testB")
    public String testB(){
        return "testB";
    }

    @GetMapping("/testC")
    public String testC(){
        return "testC";
    }

    @GetMapping("/testD")
    public String testD(){
        return "testD";
    }

    @GetMapping("/testE")
    @SentinelResource(value = "testE",blockHandler = "deal_testHotKey")
    public String testE(@RequestParam(value = "p1" ,required = false) String p1,
                        @RequestParam(value = "p2",required = false) String p2)
    {
        return "testE";
    }

    public String deal_testHotKey(String p1, String p2, BlockException exception){
        return "deal_testHotKey";//sentinel系统默认的提示都是：Blocked by sentinel(flow limiting)
    }


}
