package com.MET_ver01.service;

import com.MET_ver01.DTO.ScenarioDTO;
import com.MET_ver01.domain.ScenarioInfo;
import com.MET_ver01.repository.ScenarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScenarioService {

    private final ScenarioRepository scenarioRepository;

    public List<ScenarioInfo> scenarioFindAll() {
        return scenarioRepository.findAll();
    }

    public ScenarioDTO findScenarioInfoByScenarioId(Long scenarioId) throws UnsupportedEncodingException {
        ScenarioInfo scenarioInfo = scenarioRepository.findOne(scenarioId);
        ScenarioDTO scenarioDTO = scenarioInfo.of();
        scenarioDTO.setMailContent(URLDecoder.decode(scenarioDTO.getMailContent(), "UTF-8"));
        return scenarioDTO;
    }
}
