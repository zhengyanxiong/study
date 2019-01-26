package com.bernie.servicemember.controler;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bernie
 * @Date 2019/1/26 18:32
 **/
@RestController
public class MemberController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/getUserList")
    public List<String> getUserList() {
        List<String> listUser = new ArrayList<String>();
        listUser.add("zhangsan");
        listUser.add("lisi");
        listUser.add("yushengjun");
        listUser.add("serverPort"+serverPort);
        return listUser;
    }

    @RequestMapping("/getObjectInfo")
    public String getObjectInfo(){
        return "这是service-member项目,端口为:"+serverPort;
    }

}
