package com.MET_ver01.controller;

import com.MET_ver01.DTO.UserDTO;
import com.MET_ver01.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @GetMapping("/")
    public String loginForm(){
        return "login";
    }
    @PostMapping("/login")
    public String login(HttpServletRequest request, UserDTO userVO){

        return "redirect:/main";
    }
}
