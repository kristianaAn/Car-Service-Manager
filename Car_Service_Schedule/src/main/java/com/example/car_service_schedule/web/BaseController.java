package com.example.car_service_schedule.web;

import org.springframework.web.servlet.ModelAndView;

public abstract class BaseController {

    public ModelAndView view(String view, ModelAndView mv) {
        mv.setViewName(view);
        return mv;
    }

    public ModelAndView view(String view) {
        return this.view(view, new ModelAndView());
    }
}
