package com.iyurenko.client.dao.repository;

import com.iyurenko.client.dao.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author iyurenko
 * @since 08.04.16.
 */
public interface UserDao extends JpaRepository<User, Long> {

    User findFirstByLogin(String login);

    User findFirstByFacebookId(String id);

    User findFirstByMyOauthId(String id);

}

