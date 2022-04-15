package com.MET_ver01.DTO;

import com.MET_ver01.domain.ScenarioInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class ScenarioDTO {

    private Long scenarioId;
    private String scenarioName;
    private String sendMailUser;
    private String sendMailAddr;
    private String mailTitle;
    private String mailContent;

    public ScenarioInfo toEntity(){
        return ScenarioInfo.builder()
                .scenarioId(this.scenarioId)
                .scenarioName(this.scenarioName)
                .sendMailUser(this.sendMailUser)
                .sendMailAddr(this.sendMailAddr)
                .mailTitle(this.mailTitle)
                .mailContent(this.mailContent)
                .build();
    }

    @Builder
    public ScenarioDTO (Long scenarioId,String scenarioName, String sendMailUser, String sendMailAddr, String mailTitle, String mailContent) {
        this.scenarioId = scenarioId;
        this.scenarioName = scenarioName;
        this.sendMailUser = sendMailUser;
        this.sendMailAddr = sendMailAddr;
        this.mailTitle = mailTitle;
        this.mailContent = mailContent;
    }

}
