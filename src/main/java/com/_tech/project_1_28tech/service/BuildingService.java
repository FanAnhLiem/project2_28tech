package com._tech.project_1_28tech.service;

import com._tech.project_1_28tech.model.BuildingDTO;

import java.util.List;

public interface BuildingService {
    List<BuildingDTO> findAll(String name, Long districtid);
}
