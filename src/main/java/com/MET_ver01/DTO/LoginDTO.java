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

    @NotEmpty(message = "아이디는 필수 입력 값입니다.")
    private String loginId;

    @NotEmpty(message = "비밀번호는 필수 입력 값입니다.")
    private String loginPw;

    public LoginInfo toEntity(){
        return LoginInfo.builder()
                .loginId(this.loginId)
                .loginPw(this.loginPw)
                .build();
    }
}
