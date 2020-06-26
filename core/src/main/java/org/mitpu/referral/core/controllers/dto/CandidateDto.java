package org.mitpu.referral.core.controllers.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

public class CandidateDto extends Dto {

    @Max(Integer.MAX_VALUE)
    private Integer id;

    @Size(min = 1, max = 80)
    private String firstname;

    @Size(min = 1, max = 45)
    private String middlename;

    @Size(min = 1, max = 80)
    private String lastname;

    @Email
    private String email;

    @Size(min = 1, max = 15)
    private String phone;

    @Size(min = 1, max = 50)
    private String street1;

    @Size(min = 1, max = 50)
    private String street2;

    @Size(min = 1, max = 50)
    private String city;

    @Size(min = 1, max = 50)
    private String state;

    @Size(min = 1, max = 15)
    private String zip;

    @Size(min = 1, max = 50)
    private String country;

    @Max(4)
    private Byte workAuthorization;

    @Size(min = 1, max = 200)
    private String linkedin;

    @Max(4)
    private Byte stage;

    @Max(5)
    private Byte status;

    private Integer coordinatorId;

    public CandidateDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
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

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Byte getWorkAuthorization() {
        return workAuthorization;
    }

    public void setWorkAuthorization(Byte workAuthorization) {
        this.workAuthorization = workAuthorization;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public Byte getStage() {
        return stage;
    }

    public void setStage(Byte stage) {
        this.stage = stage;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Integer getCoordinatorId() {
        return coordinatorId;
    }

    public void setCoordinatorId(Integer coordinatorId) {
        this.coordinatorId = coordinatorId;
    }
}
