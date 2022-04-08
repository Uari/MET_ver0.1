package com.MET_ver01.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
public class TrainingUserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "training_user_id")
    private Long    trainingUserId;

    @NotNull
    @Column(name = "display_flag")
    private int     flagDisplay;

    @NotNull
    @Column(name = "display_time")
    private LocalDateTime displayTime;

    @NotNull
    @Column(name = "click_flag")
    private int     flagClick;

    @NotNull
    @Column(name = "download_flag")
    private int     flagDownload;

    @NotNull
    @Column(name = "run_flag")
    private int     flagRun;

    @NotNull
    @Column(name = "insert_private_info_flag")
    private int     flagPrivateInfoInsert;

    @NotNull
    @Column(name = "send_time")
    private LocalDateTime sendTime;

    @NotNull
    @Column(name = "encryption_code", unique = true)
    private String encryptionCode;

    @NotNull
    @ManyToOne
    //@JsonBackReference
    @JoinColumn(name = "user_id")
    private UserInfo    userInfo;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    //@JsonBackReference
    @JoinColumn(name = "training_id")
    private TrainingInfo    trainingInfo;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    //@JsonBackReference
    @JoinColumn(name = "scenario_id")
    private ScenarioInfo    scenarioInfo;

}
