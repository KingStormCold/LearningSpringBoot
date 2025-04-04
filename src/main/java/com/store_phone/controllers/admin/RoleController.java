package com.store_phone.controllers.admin;

import com.store_phone.dtos.RoleDTO;
import com.store_phone.exception.BadRequestException;
import com.store_phone.response.CommonResponse;
import com.store_phone.resquest.role.AddRoleRequest;
import com.store_phone.resquest.role.UpdateRoleRequest;
import com.store_phone.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class RoleController {
    @Autowired
    private RoleService roleService;

    //1.findAll
    @GetMapping(value = "v1/roles")
    public ResponseEntity<CommonResponse<List<RoleDTO>>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(new CommonResponse<>(roleService.findAll()));
    }

    //2.find by ID
    @GetMapping(value = "v1/roles/find/{id}")
    public ResponseEntity<CommonResponse<RoleDTO>> findById(@PathVariable("id") String roleId) {
        if (roleId == null) {
            throw new BadRequestException("501", "Id cannot empty");
        }
        RoleDTO result = roleService.findById(roleId);
        return ResponseEntity.status(HttpStatus.OK).body(new CommonResponse<>(roleService.findById(roleId)));
    }

    //3.add
    @PostMapping(value = "/v1/roles/add")
    public RoleDTO addRole(@Valid @RequestBody AddRoleRequest request) {
        return roleService.addRole(request);
    }

    //4.update
    @PutMapping(value = "v1/roles/update")
    public RoleDTO updateRole(@Valid @RequestBody UpdateRoleRequest request) {
        return roleService.updateRole(request);
    }

    //4.delete
    @DeleteMapping(value = "/v1/roles/delete")
    public void deleteRoleById(
            @RequestParam(name = "id") String roleId) {
        roleService.deleteById(roleId);
    }

}
