package MET.MET_ver01.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
public class UserInfo {

    @Id @GeneratedValue
    @Column(name = "loginIndex")
    private Long loginIndex;

    @NotEmpty
    @Column(name = "user_login_id", nullable = false, unique = true)
    private String  loginId;

    @NotEmpty
    @Column(name = "user_login_passwd", nullable = false)
    private String  loginPw;

}
