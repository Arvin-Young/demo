package com.example.demo.service;

import com.example.demo.dao.SecKillUserDao;
import com.example.demo.domain.SeckillUser;
import com.example.demo.exception.GlobalException;
import com.example.demo.result.CodeMsg;
import com.example.demo.util.MD5Util;
import com.example.demo.util.UUIDUtil;
import com.example.demo.vo.LoginVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoginService {
    @Autowired
    SecKillUserDao secKillUserDao;

    public String login(LoginVO loginVO) {
        if (loginVO == null) {
            throw new GlobalException(CodeMsg.SERVER_ERROR);
        }

        String mobile = loginVO.getMobile();
        String formPass = loginVO.getPassword();

        SeckillUser user = secKillUserDao.getByid(Long.parseLong(mobile));
        if (user == null) {
            throw new GlobalException(CodeMsg.MOBILE_NOT_EXIST);
        }

        String dbPass = user.getPassword();
        String dbSalt = user.getSalt();
        String calcPass = MD5Util.FormPassToDBPass(formPass, dbSalt);
        if (!dbPass.equals(calcPass)) {
            throw new GlobalException(CodeMsg.PASSWORD_ERROR);
        }
        String token = UUIDUtil.uuid();
        return token;
    }
}
