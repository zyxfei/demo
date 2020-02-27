package com.example.demo.controller;

import com.example.demo.DemoApplication;
import com.example.demo.entity.Response;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
//public class DemoControllerTest1 {
//
//    @Autowired
//    private DemoController demoController;
//    @Test
//    public void testBookController() {
//        Response s = demoController.findId(1);
//        System.out.println(s.getResponse());
//    }
//  
//
//import javax.servlet.ServletContext;
//
//import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
//由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
public class DemoControllerTest1 {
    @Autowired
    DemoController demoController;
    MockMvc mockMvc;
    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(demoController).build();
    }
    @Test
    public void finid() throws Exception {
//发送请求
        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/ret/{id}",1))
                .andExpect(MockMvcResultMatchers.status().isOk());
        MvcResult mvcResult = resultActions.andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("=====客户端获得反馈数据:" + result);
    }
}
