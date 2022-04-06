package com.MET_ver01.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class LoginInfo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "login_index")
    private Long loginIndex;

    @NotEmpty
    @Column(name = "user_login_id", unique = true)
    private String loginId;

    @NotEmpty
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

    @OneToOne(mappedBy = "loginInfo")
    @JsonBackReference
    private UserInfo userInfo;

}
