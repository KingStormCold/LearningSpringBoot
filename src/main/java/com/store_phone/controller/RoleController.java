package com.store_phone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.store_phone.dto.RoleDTO;
import com.store_phone.exception.BadRequestException;
import com.store_phone.request.role.AddRoleRequest;
import com.store_phone.request.role.UpdateRoleRequest;
import com.store_phone.response.CommonResponse;
import com.store_phone.service.RoleService;
import com.store_phone.service.impl.RoleServiceImpl;

import jakarta.validation.Valid;

@RestController
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	//1. lấy tất cả roles theo phân trang
	//2. pageSize(số lượng phần tử trên 1 trang), pageNumbe(trang)
	@GetMapping(value = "/v1/roles")
	public ResponseEntity<CommonResponse<List<RoleDTO>>> findAll(Pageable pageable) {
		return ResponseEntity.status(HttpStatus.OK).body(new CommonResponse<>(roleService.findAll()));
	}
	
	//2. lấy role theo id
	//PathVariable
	@GetMapping(value = "/v1/roles/{id}")
	public ResponseEntity<CommonResponse<RoleDTO>> getRoleById(@PathVariable("id") String roleId) {
		if(roleId == null) {
			throw new BadRequestException("SO1", "Id không được trống");
		}
		RoleDTO result = roleService.getRoleById(roleId);
		return ResponseEntity.status(HttpStatus.OK).body(new CommonResponse<>(result));
	}
	
	//3. thêm role
	@PostMapping(value = "/v1/roles")
	public ResponseEntity<CommonResponse<RoleDTO>> addRole(@Valid @RequestBody AddRoleRequest request) {
		return ResponseEntity.status(HttpStatus.OK).body(new CommonResponse<>(roleService.addRole(request)));
	}
	
	//4. update role, cần thêm id
	@PutMapping(value = "/v1/roles")
	public ResponseEntity<CommonResponse<RoleDTO>> updateRole(@Valid @RequestBody UpdateRoleRequest request) {
		return ResponseEntity.status(HttpStatus.OK).body(new CommonResponse<>(roleService.updateRole(request)));
	}
	
	//5. delete, cần thêm id
	@DeleteMapping(value = "/v1/roles")
	public ResponseEntity<Void> deleteRoleById(@RequestParam(name = "id") String roleId) {
		if(roleId == null || roleId.equals("")) {
			throw new BadRequestException("SO1", "Id không được trống");
		}
		roleService.deleteRoleById(roleId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
