package com.lavanet.roles_permissions_service.controller;

import com.lavanet.roles_permissions_service.model.Permission;
import com.lavanet.roles_permissions_service.service.PermissionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permissions")
public class PermissionController {

    private final PermissionService permissionService;

    public PermissionController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @PostMapping
    public Permission create(@RequestBody Permission permission) {
        return permissionService.create(permission);
    }

    @GetMapping
    public List<Permission> getAll() {
        return permissionService.getAll();
    }
}
