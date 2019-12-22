package com.project.logistics.service.impl;

import com.project.logistics.converter.UserToSafeUserConverter;
import com.project.logistics.dto.SafeUser;
import com.project.logistics.entity.RoleEntity;
import com.project.logistics.entity.UserEntity;
import com.project.logistics.repository.RoleRepository;
import com.project.logistics.repository.UserRepository;
import com.project.logistics.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.project.logistics.constants.InitialAdminConstants.ADMIN_EMAIL;
import static com.project.logistics.constants.InitialAdminConstants.ADMIN_LOGIN;
import static com.project.logistics.constants.InitialAdminConstants.ADMIN_NAME;
import static com.project.logistics.constants.InitialAdminConstants.ADMIN_PASSWORD;
import static com.project.logistics.constants.InitialAdminConstants.ADMIN_ROLE_ID;
import static com.project.logistics.constants.InitialAdminConstants.ADMIN_SURNAME;

@Service("customUserDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService {

    private RoleRepository roleRepository;
    private UserRepository userRepository;
    private UserToSafeUserConverter userConverter;
    private BCryptPasswordEncoder bCrypt;

    @Override
    public SafeUser getSafeUserByLogin(String login) {
       return userConverter.convert(getUserByLogin(login));
    }

    @Override
    public UserEntity getUserByLogin(String login) {
        return userRepository.getByLogin(login);
    }

    @Override
    public UserEntity saveUser(UserEntity userEntity) {
        userEntity.setPassword(bCrypt.encode(userEntity.getPassword()));
        return userRepository.save(userEntity);
    }

    @Override
    public List<SafeUser> getAllByRoleId(Integer roleId) {
        RoleEntity roleEntity = roleRepository.findById(roleId).get();
        List<UserEntity> userEntities = userRepository.getAllByRole(roleEntity);
        return userConverter.convert(userEntities);
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UserEntity user = getUserByLogin(login);
        return new User(user.getLogin(), user.getPassword(), getAuthority(user));
    }

    private Set<SimpleGrantedAuthority> getAuthority(UserEntity user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole().getName().toUpperCase()));
        return authorities;
    }

    @Override
    public UserEntity getUserById(Integer id) {
        return userRepository.findById(id).get();
    }

    @Override
    public Boolean setUserStatus(UserEntity user) {
        UserEntity entity = userRepository.findById(user.getId()).get();
        entity.setBlocked(user.getBlocked());
        return userRepository.save(entity).getBlocked() == user.getBlocked();
    }

    @EventListener
    public void appReady(ApplicationReadyEvent event) {
        UserEntity existingUser = userRepository.getByLogin(ADMIN_LOGIN);

        RoleEntity roleEntity = roleRepository.findById(ADMIN_ROLE_ID).get();
        UserEntity user = new UserEntity();

        if (existingUser != null) {
            user.setId(existingUser.getId());
            userRepository.delete(existingUser);
        }

        user.setRole(roleEntity);
        user.setLogin(ADMIN_LOGIN);
        user.setPassword(ADMIN_PASSWORD);
        user.setEmail(ADMIN_EMAIL);
        user.setName(ADMIN_NAME);
        user.setSurname(ADMIN_SURNAME);
        user.setBlocked((byte) 0);
        saveUser(user);
    }

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setbCrypt(BCryptPasswordEncoder bCrypt) {
        this.bCrypt = bCrypt;
    }

    @Autowired
    public void setUserConverter(UserToSafeUserConverter userConverter) {
        this.userConverter = userConverter;
    }
}
