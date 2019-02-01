package com.example.demo.controller;

import com.example.demo.result.Result;
import com.example.demo.service.LoginService;
import com.example.demo.vo.LoginVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/login")
@Slf4j
public class LoginController {
    @Autowired
    LoginService loginService;

    @RequestMapping("/to_login")
    public String toLogin() {
        return "login";
    }

    @RequestMapping(value = "/do_login")//, method = RequestMethod.POST
    @ResponseBody
    public Result<String> doLogin(LoginVO loginVO) {
        log.info("loginVO: " + loginVO.toString());
        String token = loginService.login(loginVO);
        return Result.success(token);
    }
}
