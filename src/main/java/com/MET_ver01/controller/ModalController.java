package com.MET_ver01.controller;

import com.MET_ver01.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class ModalController {

    private final OrganizationService organizationService;

    @RequestMapping(value = "/callCorpInfo", method = RequestMethod.POST)
    public String corpInfoList(HttpServletRequest request, Model model) throws Exception {

       model.addAttribute("corpInfoList", organizationService.getCorpInfoList());

        return "fragments/sendUserModal :: #corpNames";
    }
}
