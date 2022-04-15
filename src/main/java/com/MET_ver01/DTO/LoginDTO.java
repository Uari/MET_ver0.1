package com.MET_ver01.DTO;

import com.MET_ver01.domain.LoginInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
@NoArgsConstructor
public class LoginDTO {

    private String loginId;
    private String loginPw;

    public LoginInfo toEntity(){
        return LoginInfo.builder()
                .loginId(this.loginId)
                .loginPw(this.loginPw)
                .build();
    }
}
