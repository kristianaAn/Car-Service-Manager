package com.example.car_service_schedule.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class UserController extends BaseController{

    @GetMapping("/login")
    public ModelAndView getLoginPage(){
        return super.view("login-page");
    }

}
