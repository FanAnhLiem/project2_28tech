package com._tech.project_1_28tech.repository.impl;

import com._tech.project_1_28tech.model.BuildingDTO;
import com._tech.project_1_28tech.repository.BuildingRepository;
import com._tech.project_1_28tech.repository.entity.BuildingEntity;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class BuildingRepositoryImpl implements BuildingRepository {
    static final String url = "jdbc:mysql://localhost:3306/estatebasic";
    static final String username = "root";
    static final String password = "123456";
    @Override
    public List<BuildingEntity> findAll(String name, Long districtid) {
        StringBuilder sql = new StringBuilder("select * from building b where 1 = 1 ");
        if(name != null && !name.equals("")){
            sql.append(" and b.name like '%" + name + "%'");
        }
        if(districtid != null){
            sql.append(" and b.districtid = " + districtid +" ");
        }
        List<BuildingEntity> buildings = new ArrayList<>();
        try(Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql.toString());){
            while (rs.next()){
                BuildingEntity building = new BuildingEntity();
                building.setName(rs.getString("name"));
                building.setStreet(rs.getString("street"));
                building.setNumberofbasement(rs.getInt("numberofbasement"));
                building.setWard(rs.getString("ward"));
                building.setDistrictid(rs.getLong("districtid"));
                buildings.add(building);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return buildings;
    }
}
