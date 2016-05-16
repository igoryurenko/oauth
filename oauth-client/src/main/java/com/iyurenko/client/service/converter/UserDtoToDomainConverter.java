package com.iyurenko.client.service.converter;

import com.iyurenko.client.dao.domain.User;
import com.iyurenko.client.dao.domain.UserRole;
import com.iyurenko.client.web.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * @author iyurenko
 * @since 12.05.16.
 */
@Component
public class UserDtoToDomainConverter extends AbstractConverter<UserDto, User> {

    @Override
    protected User generateTarget() {
        return new User();
    }

    @Override
    public void convert(UserDto from, User to) {
        to.setId(from.getId());
        to.setFirstName(from.getFirstName());
        to.setLastName(from.getLastName());
        to.setLogin(from.getLogin());
        to.setPassword(from.getPassword());


        //Stub
        Set<UserRole> roles = new HashSet<>();
        roles.add(new UserRole("Admin"));
        to.setRoles(roles);
    }
}
