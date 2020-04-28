package com.security;

public enum RoleType {

    ADMIN(2),
    CANDIDATE(1),
    VOTER(0);

    private long id;

    RoleType(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
