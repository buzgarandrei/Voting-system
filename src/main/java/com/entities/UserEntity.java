package com.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "cnp", unique = true)
    private String cnp;

    @Column(name = "password")
    private String password;

    @Column(name = "username")
    private String username;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_role", insertable = true, updatable = true, nullable = true)
    private RoleEntity role;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY,optional =  false)
    private UserDetailEntity detail;

    @Column(name = "is_active")
    private boolean isActive;


    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    }, fetch = FetchType.LAZY)
    @JoinTable(name = "user_voting_session",
            joinColumns = @JoinColumn(name = "id_candidate"),
            inverseJoinColumns = @JoinColumn(name = "id_voting_session")
    )
    private List<VotingSessionEntity> votingSessions = new ArrayList<>();


    public boolean getIsActive() { return this.isActive; }

    public void setIsActive(boolean isActive) { this.isActive = isActive; }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RoleEntity getRole() {
        return role;
    }

    public void setRole(RoleEntity roleEntity) {
        this.role = roleEntity;
    }

    public UserDetailEntity getDetail() {
        return detail;
    }

    public void setDetail(UserDetailEntity detail) {
        this.detail = detail;
    }

    public List<VotingSessionEntity> getVotingSessions() {
        return votingSessions;
    }

    public void setVotingSessions(List<VotingSessionEntity> votingSessionEntities) {
        this.votingSessions = votingSessionEntities;
    }
}
