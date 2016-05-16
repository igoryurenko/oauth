package com.iyurenko.client.service.converter;

import com.iyurenko.client.dao.domain.User;
import com.iyurenko.client.web.dto.UserDto;
import org.springframework.stereotype.Component;

/**
 * @author iyurenko
 * @since 12.05.16.
 */
@Component
public class UserDomainToDtoConverter extends AbstractConverter<User, UserDto> {

    @Override
    protected UserDto generateTarget() {
        return new UserDto();
    }

    @Override
    public void convert(User from, UserDto to) {
        to.setId(from.getId());
        to.setFirstName(from.getFirstName());
        to.setLastName(from.getLastName());
        to.setLogin(from.getLogin());
        to.setPassword(from.getPassword());
    }
}
