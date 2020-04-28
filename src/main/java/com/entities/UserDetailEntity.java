package com.entities;

import javax.persistence.*;

@Entity
@Table(name = "user_detail")
public class UserDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id_user")
    private UserEntity user;

    @Column (name = "county")
    private String county;

    @Column (name = "locality")
    private String locality;

    @Column (name = "address")
    private String address;

    @Column (name = "email")
    private String email;




    public UserDetailEntity(){}



    public UserDetailEntity(UserEntity user, String county, String locality, String address, String email) {
        this.user = user;
        this.county = county;
        this.locality = locality;
        this.address = address;
        this.email = email;
        //this.user_id = user_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity userEntity) {
        this.user = userEntity;
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
