package com.gsitm.login.controller;

import com.gsitm.login.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * @programName : LoginController.java
 * @author      : 허빛찬샘
 * @date        : 2018. 6. 09.
 * @function    : Login의 전반적인 Controller
 *
 * [이름]   [수정일]     [내용]
 * ----------------------------------------------------------
 * 허빛찬샘	2018-06-09	초안 작성
 * 허빛찬샘	2018-06-11	내용추가
 */
@Controller
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Resource(name = "loginService")
    private LoginService loginService;

    /**
     * @methodName : login
     * @author : 허빛찬샘
     * @date : 2018. 6. 11.
     * @function : 로그인 화면 이동
     */
    @RequestMapping(value = "/login.do", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error, @RequestParam(value = "logout", required = false) String logout) {

        ModelAndView model = new ModelAndView();

        if (error != null)
            model.addObject("error", "Invalid username and password!");
        model.setViewName("/login");
        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
            model.setViewName("/login");
        }

        return model;
    }

}