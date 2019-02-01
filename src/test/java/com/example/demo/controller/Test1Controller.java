package com.example.demo.controller;

import com.example.demo.DemoApplication;
import com.example.demo.dao.SecKillUserDao;
import com.example.demo.domain.SeckillUser;
import com.example.demo.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class Test1Controller {

    @Autowired
    SecKillUserDao secKillUserDao;

    @Test
    public void save() {
        SeckillUser user = new SeckillUser();
        user.setId(18202711591L);
        user.setNickname("Arvin");
        user.setPassword("Arvin1234");
        user.setSalt("1a2b3c4d");
        //secKillUserDao.save(user);
    }

    @Test
    public void test01() {
        try {
            String path = "http://127.0.0.1:8089/test/test01";
            URL url = new URL(path);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            System.out.println(httpURLConnection.getResponseCode());
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test02() {
        try {
            User user = new User("arvin", 18);
            String path = "http://127.0.0.1:8089/test/test02";
            URL url = new URL(path);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");// 提交模式
            httpURLConnection.setRequestProperty("Content-Type","application/json; charset=UTF-8");
            // 发送POST请求必须设置如下两行
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);

            OutputStream outputStream = httpURLConnection.getOutputStream();
            ObjectMapper objectMapper = new ObjectMapper();
            outputStream.write(objectMapper.writeValueAsBytes(user));
            outputStream.flush();
            outputStream.close();

            System.out.println(httpURLConnection.getResponseCode());
            if (httpURLConnection.getResponseCode() == 200) {

            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
