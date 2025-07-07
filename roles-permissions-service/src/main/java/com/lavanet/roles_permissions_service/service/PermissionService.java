package com.lavanet.roles_permissions_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lavanet.roles_permissions_service.model.Permission;
import com.lavanet.roles_permissions_service.repository.PermissionRepository;

@Service
public class PermissionService {

    private final PermissionRepository permissionRepository;

    public PermissionService(PermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }

    public Permission create(Permission permission) {
        return permissionRepository.save(permission);
    }

    public List<Permission> getAll() {
        return permissionRepository.findAll();
    }
}
