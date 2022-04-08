package com.MET_ver01.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class LoginInfo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "login_index")
    private Long loginIndex;

    @Column(name = "user_login_id", unique = true)
    private String loginId;

    @Column(name = "user_login_passwd")
    private String loginPw;

    @ColumnDefault("0")
    @Column(name = "try_count")
    private int tryCount;

    @NotNull
    @Column(name = "create_user")
    private String createUser;

    @NotNull
    @Column(name = "create_date_time")
    private LocalDateTime createDateTime;

    @OneToOne(fetch = FetchType.LAZY,mappedBy = "loginInfo")
    //@JsonBackReference
    private UserInfo userInfo;

    @Builder
    public LoginInfo (String loginId, String loginPw, int tryCount){
        this.loginId = loginId;
        this.loginPw = loginPw;
        this.tryCount = tryCount;
    }
}
