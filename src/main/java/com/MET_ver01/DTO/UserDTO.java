package com.MET_ver01.DTO;

import com.MET_ver01.domain.UserInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class UserDTO {

    private String userName;
    private String userAddr;

    public UserInfo toEntity(){
        return UserInfo.builder()
                .userName(this.userName)
                .userAddr(this.userAddr)
                .build();
    }

    @Builder
    public UserDTO (String userName, String userAddr){
        this.userName = userName;
        this.userAddr = userAddr;
    }
}
