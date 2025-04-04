package com.store_phone.controllers.client;

import com.store_phone.response.jwt.AuthenticateResponse;
import com.store_phone.resquest.jwt.LoginRequest;
import com.store_phone.security.CustomUserDetailService;
import com.store_phone.security.JwtUtil;
import com.store_phone.utils.PasswordUtils;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private CustomUserDetailService customUserDetailService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/api/login")
    public ResponseEntity<AuthenticateResponse> authenticate(@Valid @RequestBody LoginRequest request) {
        UserDetails userDetails = customUserDetailService.loadUserByUsername(request.getUserName());
        if (ObjectUtils.isEmpty(userDetails)) {
            throw new UsernameNotFoundException("username hoặc password không đúng.");
        }
        if (PasswordUtils.checkPassword(request.getPassword(), userDetails.getPassword())) {
            String jwt = jwtUtil.generateToken(userDetails.getUsername());
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add(JwtUtil.AUTHORIZATION_HEADER, "Bearer " + jwt);
            return new ResponseEntity<>(new AuthenticateResponse(jwt), httpHeaders, HttpStatus.OK);
        }
        throw new UsernameNotFoundException("username hoặc password không đúng. - Throw");
    }
}
