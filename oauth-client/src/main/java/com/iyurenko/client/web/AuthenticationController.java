package com.iyurenko.client.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

/**
 * @author iyurenko
 * @since 10.03.16.
 */
@Controller
@RequestMapping("/")
public class AuthenticationController {

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/user")
    public @ResponseBody Principal user(Principal principal) {
        return principal;
    }

}
