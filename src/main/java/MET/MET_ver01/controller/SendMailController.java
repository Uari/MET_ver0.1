package MET.MET_ver01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SendMailController {

    @GetMapping("/sendMail")
    public String sendMail(){
        return "sendMail";
    }
}
