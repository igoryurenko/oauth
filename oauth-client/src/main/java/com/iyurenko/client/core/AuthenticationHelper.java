package com.iyurenko.client.core;

import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author iyurenko
 * @since 13.05.16.
 */
public class AuthenticationHelper {

    public static String getAuthenticationLogin() {
        return  SecurityContextHolder.getContext() != null &&
                SecurityContextHolder.getContext().getAuthentication() != null ?
                SecurityContextHolder.getContext().getAuthentication().getName() : null;
    }

}
