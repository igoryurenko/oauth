package com.iyurenko.client.service.impl;

import com.iyurenko.client.dao.domain.User;
import com.iyurenko.client.dao.repository.UserDao;
import com.iyurenko.client.service.api.UserService;
import com.iyurenko.client.service.converter.UserDomainToDtoConverter;
import com.iyurenko.client.service.converter.UserDtoToDomainConverter;
import com.iyurenko.client.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author iyurenko
 * @since 12.05.16.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDtoToDomainConverter userDtoToDomainConverter;


    @Autowired
    private UserDomainToDtoConverter userDomainToDtoConverter;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public long save(UserDto userDto) throws Exception {
        User user = userDtoToDomainConverter.convert(userDto);
        userDao.save(user);
        authentication(user);
        return user.getId();
    }

    private void authentication(User user) throws Exception {
        UserDetails userDetails = userDetailsService.loadUserByUsername(user.getLogin());
        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());
        authenticationManager.authenticate(auth);
        if(!auth.isAuthenticated()) {
            throw new Exception();
        }
        SecurityContextHolder.getContext().setAuthentication(auth);
    }

    @Override
    public UserDto load(Long id) {
        return null;
    }

    @Override
    public UserDto loadByLogin(String login) {
        return userDomainToDtoConverter.convert(userDao.findFirstByLogin(login));
    }
}
