package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult<Payment> create(@RequestBody(required = false) Payment payment){

        int result = paymentService.create(payment);
        if(result>0){
            return new CommonResult(200,"插入数据库成功",result);
        }else{
            return new CommonResult(444,"插入数据库失败",null);
        }

    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> findById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
//        System.out.println("nihao");
//        Log.info("*****插入结果"+payment);
        if (payment!=null){
            return new CommonResult(200,"查询数据库成功"+serverPort,payment);
        }else{
            return new CommonResult(444,"查询数据库失败",null);
        }
    }

    @GetMapping(value = "/payment/lb")
    public String gePaymentLB(){
        return serverPort;
    }

}
