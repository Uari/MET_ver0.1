package com.MET_ver01.service;

import com.MET_ver01.DTO.LoginDTO;
import com.MET_ver01.domain.LoginInfo;
import com.MET_ver01.repository.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService{

    private final LoginRepository loginRepository;

    public LoginInfo loginOne(LoginDTO loginDTO) throws Exception{
       return loginRepository.loginOne(loginDTO.toEntity().getLoginId());
    }
}
