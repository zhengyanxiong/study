package com.bernie.serviceorder.controller;

import com.bernie.serviceorder.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Bernie
 * @Date 2019/1/26 19:31
 **/
@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;

    @RequestMapping("/getOrderUserList")
    List<String> getOrderByUserList() {
        return memberService.getOrderByUserList();
    }

    @RequestMapping("/getObjectInfo")
    public String getObjectInfo(){
        return "这是service-order";
    }
}
