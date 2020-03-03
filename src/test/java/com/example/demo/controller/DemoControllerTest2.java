package com.example.demo.controller;

import com.example.demo.DemoApplication;
import com.example.demo.entity.Response;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class DemoControllerTest2 {

    @Autowired
    private DemoController demoController;

    @Test
    public void testController() {
      //  Response s = demoController.findId(1);
        //System.out.println(s.getResponse());
    }
}