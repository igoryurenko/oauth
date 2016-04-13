package com.iyurenko.client.dao.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * @author iyurenko
 * @since 08.04.16.
 */

@Entity(name = "user")
public class User extends AbstractIdentifier {

    @Column(name = "facebook_id", unique = true)
    private String facebookId;

    @Column(name = "my_oauth_id", unique = true)
    private String myOauthId;

    @Column(unique = true)
    private String login;

    @Column
    private String password;

    @Column(name = "name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(unique = true)
    private String email;

    @Column(columnDefinition = "TINYINT")
    private boolean enabled = true;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="id_user", nullable = false)
    private Set<UserRole> roles;

    /* ------------------ getters and setters ------------------------- */

    public String getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }

    public String getMyOauthId() {
        return myOauthId;
    }

    public void setMyOauthId(String myOauthId) {
        this.myOauthId = myOauthId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<UserRole> roles) {
        this.roles = roles;
    }
}
