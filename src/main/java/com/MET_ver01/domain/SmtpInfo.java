package com.MET_ver01.domain;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
public class SmtpInfo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "smtp_index")
    private Long smtpIndex;

    @NotNull
    @Column(name = "smtp_host")
    private String smtpHost;

    @NotNull
    @Column(name = "smtp_id")
    private String smtpId;

    @NotNull
    @Column(name = "smtp_pw")
    private String smtpPw;

    @NotNull
    @Column(name = "smtp_port")
    private String smtpPort;

    @NotNull
    @Column(name = "create_date_time")
    private LocalDateTime createDateTime;

    @OneToOne(fetch = FetchType.LAZY,mappedBy = "smtpInfo")
    private UserInfo userInfo;

}
