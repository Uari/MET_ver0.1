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
public class CorpInfo {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "corp_id")
        private Long corpId;

        @NotNull
        @Column(name = "corp_name")
        private String corpName;

        @NotNull
        @Column(name = "create_user")
        private String createUser;

        @NotNull
        @Column(name = "create_date_time")
        private LocalDateTime createDateTime;

        //@JsonManagedReference
        @OneToMany(mappedBy = "corpInfo")
        private List<DepInfo> depInfo = new ArrayList<>();
}
