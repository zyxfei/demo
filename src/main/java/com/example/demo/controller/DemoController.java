package com.example.demo.controller;

import com.example.demo.annotation.ParameterValid;
import com.example.demo.annotation.PathAndQueryParamValid;
import com.example.demo.aop.ParamValidSupport;
import com.example.demo.entity.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import javax.validation.constraints.Max;

@Controller

public class DemoController {
    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);
    @PathAndQueryParamValid
    @ResponseBody
    @Valid
    @RequestMapping(path = "/ret/{id}", method = RequestMethod.GET)
    public Response findId(@Valid @PathVariable("id")
                           @ParameterValid(type = Integer.class, msg = "isInt must be more than 2 ",
                                   isMin = true, min = 2
                           )
                                   Integer id) {
        // Assert.isTrue( id < 99 && id > 1, "Please give a num in range 1-99");
        Response rsp = new Response();
        rsp.setResponse(id);
        logger.info("rep:" + id);

        return rsp;
    }
}
