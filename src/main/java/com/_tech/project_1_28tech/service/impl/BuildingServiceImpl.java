package com._tech.project_1_28tech.service.impl;

import com._tech.project_1_28tech.model.BuildingDTO;
import com._tech.project_1_28tech.repository.BuildingRepository;
import com._tech.project_1_28tech.repository.entity.BuildingEntity;
import com._tech.project_1_28tech.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class BuildingServiceImpl implements BuildingService {
    @Autowired
    private BuildingRepository repo;
    @Override
    public List<BuildingDTO> findAll(String name, Long districtid) {
        List<BuildingEntity> buildingEntities = repo.findAll(name, districtid);
        List<BuildingDTO> result = new ArrayList<>();
        for (BuildingEntity item : buildingEntities) {
            BuildingDTO dto = new BuildingDTO();
            dto.setName(item.getName());
            dto.setAddress(item.getStreet() + ", "+item.getWard());
            dto.setNumberofbasement(item.getNumberofbasement());
            dto.setDistrictid(item.getDistrictid());
            result.add(dto);
        }
        return result;
    }
}
