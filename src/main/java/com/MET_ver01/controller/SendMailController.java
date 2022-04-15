package com.MET_ver01.controller;

import com.MET_ver01.DTO.ScenarioDTO;
import com.MET_ver01.service.ScenarioService;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Controller
@RequiredArgsConstructor
public class SendMailController {

    private final ScenarioService scenarioService;

    @GetMapping("/sendMail")
    public String sendMail(Model model){

        model.addAttribute("scenarioInfoList", scenarioService.scenarioFindAll());

        return "/sendMail";
    }

    @RequestMapping(value = "/scenarioInfoLoad", method = RequestMethod.POST)
    public String userInfoList(@NotNull HttpServletRequest request, Model model) throws Exception {

        Long scenarioId = Long.parseLong(request.getParameter("scenarioId"));
        ScenarioDTO scenarioDto = scenarioService.findScenarioInfoByScenarioId(scenarioId);

        model.addAttribute("scenarioInfo", scenarioDto);

        return "sendMail :: #scenarioInfoForm";
    }
}
