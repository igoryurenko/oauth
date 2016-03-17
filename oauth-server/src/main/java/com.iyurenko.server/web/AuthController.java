package com.iyurenko.server.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author iyurenko
 * @since 17.03.16.
 */
@Controller
@RequestMapping("/")
public class AuthController {

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

}
