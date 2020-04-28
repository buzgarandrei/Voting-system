package com.dto.request;

public class UserDetailRequest {

    private Long id;
    private String userName;
    private String county;
    private String locality;
    private String address;
    private String email;

    public UserDetailRequest() {
    }

    public UserDetailRequest(Long id, String userName, String county, String locality, String address, String email) {
        this.id = id;
        this.userName = userName;
        this.county = county;
        this.locality = locality;
        this.address = address;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
