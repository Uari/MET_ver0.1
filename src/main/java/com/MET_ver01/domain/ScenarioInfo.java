package com.MET_ver01.domain;

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
public class ScenarioInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "scenario_id")
    private Long    scenarioId;

    @NotNull
    @Column(name = "scenario_name")
    private String  scenarioName;

    @NotNull
    @Column(name = "send_mail_user")
    private String  sendMailUser;

    @NotNull
    @Column(name = "send_mail_addr")
    private String  sendMailAddr;

    @NotNull
    @Column(name = "mail_title")
    private String  mailTitle;

    @NotNull
    @Column(name = "mail_content", columnDefinition = "LONGTEXT")
    private String  mailContent;

    @Column(name = "attach_file_path")
    private String  filePath;

    @NotNull
    @Column(name = "create_date_time")
    private LocalDateTime createDateTime;

    @NotNull
    @Column(name = "create_user")
    private String  createUser;

    //숫자로 할지 문자로 할지 아직 안정함 추후 더 맞는 방법 채택
    @NotNull
    @Column(name = "scenario_difficulty")
    private String  scenarioDifficulty;

    /* 0 = 해당부분 시나리오에 포함 안됨, 1 = 해당부분 시나리오에 포함됨
    0       0       0       0           0
    메일열람 링크클릭  다운로드 첨부파일실행  개인정보입력
    입력은 10진수로 변환해서 입력
    ex) 10110 = 22
    */
    @NotNull
    @Column(name = "scenario_element")
    private int     scenarioElement;

    @OneToMany(mappedBy = "scenarioInfo")
    //@JsonManagedReference
    private List<ScenarioInfo> scenarioInfo = new ArrayList<>();

}
