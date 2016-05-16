package com.iyurenko.client.service.impl;

import com.iyurenko.client.dao.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author iyurenko
 * @since 08.04.16.
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Transactional(readOnly=true)
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        com.iyurenko.client.dao.domain.User user = userDao.findFirstByLogin(login);
        return buildUserForAuthentication(user, user.getRoles().stream().map(userRole -> new SimpleGrantedAuthority(userRole.getRole())).collect(Collectors.toList()));
    }

    // Converts User user to org.springframework.security.core.userdetails.User
    private User buildUserForAuthentication(com.iyurenko.client.dao.domain.User user, List<GrantedAuthority> authorities) {
        return new User(user.getLogin(), user.getPassword(), user.isEnabled(), true, true, true, authorities);
    }

}

