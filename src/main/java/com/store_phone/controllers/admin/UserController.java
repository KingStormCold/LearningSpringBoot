package com.store_phone.controllers.admin;

import com.store_phone.dtos.UserDTO;
import com.store_phone.response.CommonResponse;
import com.store_phone.response.ResultDataPaging;
import com.store_phone.response.user.UserInfo;
import com.store_phone.resquest.user.AddUserRequest;
import com.store_phone.resquest.user.UpdateUserRequest;
import com.store_phone.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

//    @PreAuthorize("hasAnyAuthority('ADMIN') or hasAnyAuthority('ADMIN_USER')")
    @GetMapping(value = "/v1/users/findAll")
    public ResponseEntity<CommonResponse<ResultDataPaging<UserInfo>>> findAll(Pageable pageable) {
        return ResponseEntity.ok(new CommonResponse<>(userService.findAll(pageable)));
    }

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('ADMIN_USER')")
    @PostMapping(value = "/v1/users/create")
    public ResponseEntity<CommonResponse<UserInfo>> addUser (@Valid @RequestBody AddUserRequest request) {
        UserDTO userDTO = userService.addUser(request);
        UserInfo userInfo = new UserInfo(userDTO);
        return ResponseEntity.ok(new CommonResponse<>(userInfo));
    }

    @GetMapping(value = "v1/users/{userName}")
    public ResponseEntity<CommonResponse<UserInfo>> findByUsername(@PathVariable("userName") String userName) {
        UserDTO userDTO = userService.getUserInfo(userName);
        UserInfo userInfo = new UserInfo(userDTO);
        return ResponseEntity.ok(new CommonResponse<>(userInfo));
    }

    @PutMapping(value = "v1/users/update")
    public ResponseEntity<CommonResponse<UserInfo>> updateUser(@Valid @RequestBody UpdateUserRequest request) {
        UserDTO userDTO = userService.updateUser(request);
        UserInfo userInfo = new UserInfo(userDTO);
        return ResponseEntity.ok(new CommonResponse<>(userInfo));
    }

    @DeleteMapping(value = "v1/users/delete/{userName}")
    public ResponseEntity<?> deleteByUseName(@PathVariable("userName") String userName) {
        userService.deleteUser(userName);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
