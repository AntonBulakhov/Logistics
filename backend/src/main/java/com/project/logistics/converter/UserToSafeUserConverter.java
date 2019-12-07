package com.project.logistics.converter;

import com.project.logistics.dto.SafeUser;
import com.project.logistics.entity.UserEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserToSafeUserConverter implements Converter<UserEntity, SafeUser> {

    @Override
    public SafeUser convert(UserEntity userEntity) {
        SafeUser safeUser = new SafeUser();
        safeUser.setId(userEntity.getId());
        safeUser.setBlocked(userEntity.getBlocked());
        safeUser.setEmail(userEntity.getEmail());
        safeUser.setName(userEntity.getName());
        safeUser.setSurname(userEntity.getSurname());
        return safeUser;
    }
}
