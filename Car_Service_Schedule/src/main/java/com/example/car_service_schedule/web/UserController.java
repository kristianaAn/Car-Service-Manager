package com.example.car_service_schedule.web;

import com.example.car_service_schedule.models.dto.LoginUserInfoDTO;
import com.example.car_service_schedule.services.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class UserController extends BaseController{

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public ModelAndView getLoginPage(LoginUserInfoDTO loginUserInfoDTO){
        return super.view("login-page");
    }

    @PostMapping("/login")
    public ModelAndView loginUser(@Valid @ModelAttribute(name = "loginUserInfoDTO") LoginUserInfoDTO loginUserInfoDTO,
                                  BindingResult bindingResult, ModelAndView mv) {
        if (bindingResult.hasErrors()) {
            mv.setViewName("login-page");
            return mv;
        }

        this.userService.loginUser(loginUserInfoDTO);
        mv.setViewName("index");
        return mv;
    }

}
