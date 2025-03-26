package com.store_phone.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.store_phone.dto.UserDTO;
import com.store_phone.request.user.AddUserRequest;
import com.store_phone.request.user.UpdateUserRequest;
import com.store_phone.response.CommonResponse;
import com.store_phone.response.ResultDataPaging;
import com.store_phone.response.user.UserInfo;
import com.store_phone.service.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping(value = "/v1/users")
//	@PreAuthorize("hasRole('ADMIN')") One role only
//	@PreAuthorize("hasAnyRole('ADMIN', 'ADMIN_USER')") Multiple roles
//	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('ADMIN_USER')") If roles are stored with "ROLE_" prefix
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('ADMIN_USER')")
	public ResponseEntity<CommonResponse<ResultDataPaging<UserInfo>>> findAll(Pageable pageable) {
		return ResponseEntity.ok(new CommonResponse<>(userService.findAll(pageable)));
	}
	
	@PostMapping(value = "/v1/users")
	public ResponseEntity<CommonResponse<UserDTO>> addUser(@Valid @RequestBody AddUserRequest request){
		return ResponseEntity.ok(new CommonResponse<>(userService.addUser(request)));
	}
	
	@GetMapping(value = "/v1/user/{userName}")
	@PreAuthorize("hasAuthority('ADMIN_PR')")
	public ResponseEntity<CommonResponse<UserInfo>> findByUsername(@PathVariable("userName") String userName) {
		UserDTO userDTO = userService.getInfoUser(userName);
		UserInfo userInfo = new UserInfo(userDTO);
		return ResponseEntity.ok(new CommonResponse<>(userInfo));
	}
	
	@PutMapping(value = "/v1/users")
	public ResponseEntity<CommonResponse<UserInfo>> updateUser(@Valid @RequestBody UpdateUserRequest request){
		UserDTO userDTO = userService.updateUser(request);
		UserInfo userInfo = new UserInfo(userDTO);
		return ResponseEntity.ok(new CommonResponse<>(userInfo));
	}
	
	@DeleteMapping(value = "/v1/user/{userName}")
	public ResponseEntity<?> deleteByUserName(@PathVariable("userName") String userName){
		userService.deleteUser(userName);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
}
