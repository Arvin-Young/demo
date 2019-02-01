package com.example.demo.controller;

import com.example.demo.dao.SecKillUserDao;
import com.example.demo.domain.SeckillUser;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    SecKillUserDao secKillUserDao;

    @RequestMapping(value = "/test01")
    public String test01() {
        return "success";
    }

    @RequestMapping(value = "/test02", method = RequestMethod.POST)
    public User test02(@RequestBody User user) {
        System.out.println(user.toString());
        return user;
    }

    @RequestMapping(value = "/save")
    public String save() {
        SeckillUser user = new SeckillUser();
        user.setId(18202711592L);
        user.setNickname("Arvin01");
        user.setPassword("Arvin1234");
        user.setSalt("1a2b3c4d");
        secKillUserDao.save(user);
        return "login";
    }
}
