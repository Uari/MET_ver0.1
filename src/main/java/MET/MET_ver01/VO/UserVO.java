package MET.MET_ver01.VO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class UserVO {
    private String  user_Id;
    private String  user_Pw;
    private LocalDateTime createDateTime;
}
