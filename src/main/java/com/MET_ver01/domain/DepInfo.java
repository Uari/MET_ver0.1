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
@Getter @Setter
public class DepInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dep_id")
    private Long depId;

    @NotNull
    @Column(name = "dep_name")
    private String depName;

    @NotNull
    @Column(name = "create_user")
    private String createUser;

    @NotNull
    @Column(name = "create_date_time")
    private LocalDateTime createDateTime;

    @OneToMany(mappedBy = "depInfo")
    @JsonManagedReference
    private List<TeamInfo> teamInfo = new ArrayList<>();

    //@JsonBackReference
    @NotNull
    @ManyToOne
    @JoinColumn(name = "corp_id")
    private CorpInfo corpInfo;

}
