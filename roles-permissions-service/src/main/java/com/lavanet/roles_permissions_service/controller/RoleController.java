package com.lavanet.roles_permissions_service.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Role create(@RequestBody Role role) {
        return roleService.create(role);
    }

    @GetMapping
    public List<Role> getAll() {
        return roleService.getAll();
    }

    @PostMapping("/{roleId}/permissions")
    public Role addPermissions(@PathVariable Long roleId, @RequestBody Map<String, List<Long>> request) {
        Set<Long> permissionIds = Set.copyOf(request.get("permissionIds"));
        return roleService.addPermissions(roleId, permissionIds);
    }
}
