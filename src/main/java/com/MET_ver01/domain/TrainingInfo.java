package com.MET_ver01.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class TrainingInfo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "training_id")
    private Long        trainingId;

    @NotNull
    @Column(name = "training_name")
    private String      trainingName;

    @NotNull
    @Column(name = "training_st_dt")
    private LocalDateTime startTime;

    @NotNull
    @Column(name = "training_end_dt")
    private LocalDateTime endTime;

    @NotNull
    @CreatedDate
    @Column(name = "create_date_time")
    private LocalDateTime createDateTime;

    @NotNull
    @ManyToOne
    //@JsonBackReference
    @JoinColumn(name = "creator_user_id")
    private UserInfo    userInfo;

    @OneToMany(mappedBy = "trainingInfo")
    //@JsonManagedReference
    private List<TrainingUserInfo> trainingUserInfo = new ArrayList<>();

}
