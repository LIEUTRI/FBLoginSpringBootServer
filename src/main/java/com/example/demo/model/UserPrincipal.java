package com.example.demo.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UserPrincipal implements UserDetails {
    private User mUser;
    public UserPrincipal() {
    }
    public UserPrincipal(User user) {
        mUser = user;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(mUser.getUserRole()));
    }

    public String getId() {
        return mUser.getId();
    }
    @Override
    public String getPassword() {
        return mUser.getPassword();
    }
    @Override
    public String getUsername() {
        return mUser.getId();
    }
    public String getEmail() {
        return mUser.getEmail();
    }
    public String getFirstName() {
        return mUser.getFirstName();
    }
    public String getLastName() {
        return mUser.getLastName();
    }
    public String getGender() {
        return mUser.getGender();
    }
    public String getBirthday() {
        return mUser.getBirthday();
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }
}
