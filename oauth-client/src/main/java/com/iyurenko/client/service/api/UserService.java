package com.iyurenko.client.service.api;

import com.iyurenko.client.web.dto.UserDto;

/**
 * @author iyurenko
 * @since 12.05.16.
 */
public interface UserService extends GenericService<UserDto> {

    UserDto loadByLogin(String login);

}
