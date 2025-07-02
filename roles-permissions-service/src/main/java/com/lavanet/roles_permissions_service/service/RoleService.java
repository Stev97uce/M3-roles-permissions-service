package com.lavanet.roles_permissions_service.service;

import com.lavanet.roles_permissions_service.model.Role;
import com.lavanet.roles_permissions_service.model.Permission;
import com.lavanet.roles_permissions_service.repository.RoleRepository;
import com.lavanet.roles_permissions_service.repository.PermissionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class RoleService {

    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository;

    public RoleService(RoleRepository roleRepository, PermissionRepository permissionRepository) {
        this.roleRepository = roleRepository;
        this.permissionRepository = permissionRepository;
    }

    public Role create(Role role) {
        return roleRepository.save(role);
    }

    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    public Optional<Role> getById(Long id) {
        return roleRepository.findById(id);
    }

    public Role addPermissions(Long roleId, Set<Long> permissionIds) {
        Role role = roleRepository.findById(roleId).orElseThrow();
        Set<Permission> permissions = permissionRepository.findAllById(permissionIds).stream().collect(java.util.stream.Collectors.toSet());
        role.getPermissions().addAll(permissions);
        return roleRepository.save(role);
    }
}
