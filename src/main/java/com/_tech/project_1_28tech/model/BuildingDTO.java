package com._tech.project_1_28tech.model;

public class BuildingDTO {
    private String name;
    private Integer numberofbasement;
    private String address;
    private Long districtid;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberofbasement() {
        return numberofbasement;
    }

    public void setNumberofbasement(Integer numberofbasement) {
        this.numberofbasement = numberofbasement;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getDistrictid() {
        return districtid;
    }

    public void setDistrictid(Long districtid) {
        this.districtid = districtid;
    }
}
