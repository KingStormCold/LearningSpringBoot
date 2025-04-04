package com.store_phone.security;

import com.store_phone.dtos.UserDTO;
import com.store_phone.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDTO userDTO = userService.findByUserName(username);
        if (userDTO == null) {
            new UsernameNotFoundException("User not found");
        }
        List<SimpleGrantedAuthority> authorities = userDTO.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoleId())).collect(Collectors.toList());
        return new User(username, userDTO.getPassword(), authorities);
    }
}
