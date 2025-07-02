package com.lavanet.roles_permissions_service.controller;

import java.util.List;
import java.util.Set;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.lavanet.roles_permissions_service.model.Role;
import com.lavanet.roles_permissions_service.service.RoleService;

@RestController
@RequestMapping("/roles")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Role create(@RequestBody Role role) {
        return roleService.create(role);
    }

    @GetMapping
    public List<Role> getAllRoles() {
        return roleService.getAll();
    }

    @GetMapping("/{roleId}")
    public Role getRoleById(@PathVariable Long roleId) {
        return roleService.getById(roleId)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Role not found with id: " + roleId));
    }

    @PostMapping("/{roleId}/permissions")
    public Role addPermissions(
        @PathVariable Long roleId,
        @RequestBody Set<Long> permissionIds) {
        
        if (permissionIds == null || permissionIds.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Permission IDs cannot be empty");
        }

        return roleService.addPermissions(roleId, permissionIds);
    }
}
