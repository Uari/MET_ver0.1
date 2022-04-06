package com.MET_ver01.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class UserDTO {
    private String  userId;
    private String  userPw;
    private LocalDateTime createDateTime;
}
