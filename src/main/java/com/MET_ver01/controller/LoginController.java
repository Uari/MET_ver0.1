package com.MET_ver01.controller;

import com.MET_ver01.DTO.LoginDTO;
import com.MET_ver01.domain.LoginInfo;
import com.MET_ver01.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@Slf4j
public class LoginController {

    private final LoginService loginService;

    @GetMapping("/")
    public String loginForm(){

        return "login";
    }

    @PostMapping("/login")
    public String login(HttpServletRequest request, @Valid LoginDTO loginDTO) throws Exception {

        String tagetUrl = "";
        LoginInfo loginIf = loginService.loginOne(loginDTO);
        if(loginIf == null){    //아이디가 존제하지 않음
            System.out.println("Error : 1");
            tagetUrl = "redirect:/";
        } else {
            if(loginIf.getLoginPw().equals(loginDTO.getLoginPw())){ //아이디도 일치 비번도 일치
                System.out.println("Error : 2");
                HttpSession session = request.getSession();
                session.setAttribute("loginId", loginDTO.getLoginId());
                tagetUrl = "redirect:/main";
            }else{  //아이디는 있으나 비번이 일치하지 않음
                System.out.println("Error : 3");
                tagetUrl = "redirect:/";
            }
        }
        return tagetUrl;
    }
}
