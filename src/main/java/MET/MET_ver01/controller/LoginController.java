package MET.MET_ver01.controller;

import MET.MET_ver01.VO.UserVO;
import MET.MET_ver01.domain.UserInfo;
import MET.MET_ver01.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;

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
    public String login(UserVO userVO){

        return "redirect:/main";
    }
}
