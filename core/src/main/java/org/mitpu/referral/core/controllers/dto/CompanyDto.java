package org.mitpu.referral.core.controllers.dto;

public class CompanyDto extends Dto {

    private Integer id;

    private String name;

    private String careerLink;

    private String industry;

    private Byte workAuthorization;

    private String city;

    private String state;

    private String country;

    public CompanyDto() {
        super("Company");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCareerLink() {
        return careerLink;
    }

    public void setCareerLink(String careerLink) {
        this.careerLink = careerLink;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public Byte getWorkAuthorization() {
        return workAuthorization;
    }

    public void setWorkAuthorization(Byte workAuthorization) {
        this.workAuthorization = workAuthorization;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
