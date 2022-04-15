package com.MET_ver01.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class TeamInfo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private Long teamId;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
   // @JsonBackReference
    @JoinColumn(name = "dep_id")
    private DepInfo depInfo;

    @NotNull
    @Column(name = "team_name")
    private String teamName;

    @NotNull
    @Column(name = "create_user")
    private String createUser;

    @NotNull
    @Column(name = "create_date_time")
    private LocalDateTime createDateTime;

    @OneToMany(mappedBy = "teamInfo")
   // @JsonManagedReference
    private List<UserInfo> userInfo = new ArrayList<>();



}
