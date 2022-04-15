package com.MET_ver01.domain;

import com.MET_ver01.DTO.UserDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class UserInfo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @NotNull
    @Column(name = "user_name")
    private String userName;

    @NotNull
    @Column(name = "user_addr")
    private String userAddr;

    @ManyToOne(fetch = FetchType.LAZY)
    //@JsonBackReference
    @JoinColumn(name = "team_id")
    private TeamInfo teamInfo;

    @OneToOne(fetch = FetchType.LAZY)
    //@JsonManagedReference
    @JoinColumn(name = "login_index")
    private LoginInfo loginInfo;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "smtp_index")
    private SmtpInfo smtpInfo;

    @OneToMany(mappedBy = "userInfo")
    //@JsonManagedReference
    private List<TrainingInfo> trainingInfo = new ArrayList<>();

    @OneToMany(mappedBy = "userInfo")
    //@JsonManagedReference
    private List<TrainingUserInfo> trainingUserInfo = new ArrayList<>();

    @NotNull
    @Column(name = "create_user")
    private String createUser;

    @NotNull
    @CreatedDate
    @Column(name = "create_date_time")
    private LocalDateTime createDateTime;

    @NotNull
    @Column(name = "user_grant")
    private int userGrant;

    @NotNull
    @LastModifiedDate
    @Column(name = "last_update_time")
    private LocalDateTime last_update_time;

    @Builder
    public UserInfo (String userName, String userAddr){
        this.userName = userName;
        this.userAddr = userAddr;
    }

    public UserDTO of(){
        return UserDTO.builder()
                .userName(this.userName)
                .userAddr(this.userAddr)
                .build();
    }

}
