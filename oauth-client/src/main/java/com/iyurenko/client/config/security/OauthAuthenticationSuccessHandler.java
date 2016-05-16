package com.iyurenko.client.config.security;

import com.iyurenko.client.core.OauthServer;
import com.iyurenko.client.dao.domain.User;
import com.iyurenko.client.dao.domain.UserRole;
import com.iyurenko.client.dao.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author iyurenko
 * @since 08.04.16.
 */
@Component("oauthAuthenticationSuccessHandler")
public class OauthAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    public OauthAuthenticationSuccessHandler() {
//        setDefaultTargetUrl("/login");
    }

    @Autowired
    private UserDao userDao;


    @Autowired
    @Qualifier("facebookRestTemplate")
    private OAuth2RestTemplate facebookRestTemplate;


    @Transactional
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        super.onAuthenticationSuccess(request, response, authentication);

        OauthServer oauthServer = OauthServer.detectOauthServer(request.getRequestURI());
        User user = null;

        String principal = (String) authentication.getPrincipal();
        if (oauthServer.equals(OauthServer.FACEBOOK)) {
            user = userDao.findFirstByFacebookId(principal);
        } else if (oauthServer.equals(OauthServer.MY_OAUTH)) {
            user = userDao.findFirstByMyOauthId(principal);
        }

        checkAndCreateUser(oauthServer, user, (OAuth2Authentication) authentication);
    }

    private void checkAndCreateUser(OauthServer oauthServer, User user, OAuth2Authentication oAuth2Authentication) {
        if (user == null) {
            user = new User();


            Authentication userAuthentication = ((OAuth2Authentication) oAuth2Authentication).getUserAuthentication();


            user.setFirstName((String) ((Map) userAuthentication.getDetails()).get("name"));

            if (oauthServer.equals(OauthServer.FACEBOOK)) {
                user.setFacebookId(userAuthentication.getName());

                // load and fill in data from facebook

                // For example load gender
                // facebookRestTemplate.getForEntity("https://graph.facebook.com/me?fields=gender", HashMap.class);


            } else if (oauthServer.equals(OauthServer.MY_OAUTH)) {
                user.setMyOauthId(userAuthentication.getName());

                // load and fill in data from ...
            }


            user.setLogin(userAuthentication.getName());
            user.setRoles(userAuthentication.getAuthorities().stream().map(auth -> new UserRole(auth.getAuthority())).collect(Collectors.toSet()));
            userDao.save(user);
        }

    }

}
