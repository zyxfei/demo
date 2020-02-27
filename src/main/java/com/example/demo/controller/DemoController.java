package com.example.demo.controller;

import com.example.demo.entity.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {
    @ResponseBody
    @RequestMapping(path = "/ret/{id}", method = RequestMethod.GET)
    public Response findId(@PathVariable int id) {
        Response rsp = new Response(0);
        rsp.setResponse(id);
        return rsp;
    }
}
