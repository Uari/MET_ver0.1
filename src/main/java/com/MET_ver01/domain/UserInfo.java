package com.MET_ver01.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
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

    @ManyToOne
    //@JsonBackReference
    @JoinColumn(name = "team_id")
    private TeamInfo teamInfo;

    @OneToOne
    //@JsonManagedReference
    @JoinColumn(name = "login_index")
    private LoginInfo loginInfo;

    @OneToOne
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
    private String          createUser;

    @NotNull
    @CreatedDate
    @Column(name = "create_date_time")
    private LocalDateTime   createDateTime;

    @NotNull
    @Column(name = "user_grant")
    private int             userGrant;

    @NotNull
    @LastModifiedDate
    @Column(name = "last_update_time")
    private LocalDateTime   last_update_time;
}
