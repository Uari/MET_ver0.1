package com.MET_ver01.repository;

import com.MET_ver01.domain.LoginInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class LoginRepository {

    private final EntityManager em;

    public LoginInfo loginOne(String loginId) {
        try {
            return em.createQuery("select l from LoginInfo l where l.loginId = :loginId", LoginInfo.class)
                    .setParameter("loginId", loginId)
                    .getSingleResult();

        } catch (Exception e) {
            return null;
        }
    }
}
