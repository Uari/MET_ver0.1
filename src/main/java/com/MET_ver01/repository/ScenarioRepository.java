package com.MET_ver01.repository;

import com.MET_ver01.domain.ScenarioInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ScenarioRepository {

    private final EntityManager em;

    public List<ScenarioInfo> findAll() {
        return em.createQuery("select s from ScenarioInfo s", ScenarioInfo.class)
                .getResultList();
    }

    public ScenarioInfo findOne(Long scenarioId) {
        return em.find(ScenarioInfo.class, scenarioId);
    }
}
