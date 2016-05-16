package com.iyurenko.client.web;

import com.iyurenko.client.core.AuthenticationHelper;
import com.iyurenko.client.service.api.UserService;
import com.iyurenko.client.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

/**
 * @author iyurenko
 * @since 10.03.16.
 */
@Controller
@RequestMapping("/")
public class AuthenticationController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user")
    @PreAuthorize("isAuthenticated()")
    public @ResponseBody UserDto user() {
        return userService.loadByLogin(AuthenticationHelper.getAuthenticationLogin());
    }

    @RequestMapping(value = "/login/signup", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody Long signup(@RequestBody UserDto user) throws Exception {
        return userService.save(user);
    }

}
