package com.iyurenko.client.config;

import java.util.stream.Stream;

/**
 * @author iyurenko
 * @since 11.04.16.
 */
public enum OauthServer {

    FACEBOOK("/login/facebook"),
    MY_OAUTH("/login/my");


    OauthServer(String urlPattern) {
        this.urlPattern = urlPattern;
    }

    private String urlPattern;

    public static OauthServer detectOauthServer(final String uri) {
        return Stream.of(OauthServer.values()).filter(server -> server.getUrlPattern().equals(uri)).findFirst().get();
    }

    public String getUrlPattern() {
        return urlPattern;
    }

}
