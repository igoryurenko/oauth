package com.iyurenko.client.dao.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

/**
 * @author iyurenko
 * @since 11.04.16.
 */

@Entity(name = "user_role")
public class UserRole extends AbstractIdentifier {

    public UserRole() {}

    public UserRole(String role) {
        this.role = role;
    }

    @Column(nullable = false)
    private String role;

    @Column
    private String description;

    /* ----------------- getters and setters ------------------------ */

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
