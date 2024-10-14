package com.company.classworkrelationhomework.service.impl;

import com.company.classworkrelationhomework.model.entity.Role;
import com.company.classworkrelationhomework.model.enums.ErrorCode;
import com.company.classworkrelationhomework.model.enums.Roles;
import com.company.classworkrelationhomework.model.exception.NotFoundException;
import com.company.classworkrelationhomework.repository.RoleRepository;
import com.company.classworkrelationhomework.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public Role getUserRole() {
        return roleRepository.findByRole(Roles.USER).orElseThrow(()-> new NotFoundException(ErrorCode.NOT_FOUND,Roles.USER.name()));
    }
}
