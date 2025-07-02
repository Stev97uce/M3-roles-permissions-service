package com.lavanet.roles_permissions_service.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lavanet.roles_permissions_service.model.Permission;
import com.lavanet.roles_permissions_service.service.PermissionService;

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
