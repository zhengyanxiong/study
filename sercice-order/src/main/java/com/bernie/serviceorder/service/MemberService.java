package com.bernie.serviceorder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author Bernie
 * @Date 2019/1/26 19:25
 **/
@SuppressWarnings("unchecked")
@Service
public class MemberService {
    @Autowired
    RestTemplate restTemplate;
    //rest方式

    public List<String> getOrderByUserList() {
        return restTemplate.getForObject("http://service-member/getUserList", List.class);
    }

}
