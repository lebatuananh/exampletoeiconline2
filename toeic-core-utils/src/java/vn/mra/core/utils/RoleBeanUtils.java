package vn.mra.core.utils;

import vn.mra.core.dto.RoleDTO;
import vn.mra.core.peristence.entity.RoleEntity;

public class RoleBeanUtils {
    public static RoleDTO entityToDTO(RoleEntity roleEntity){
        RoleDTO roleDTO=new RoleDTO();
        roleDTO.setRoleId(roleEntity.getRoleId());
        roleDTO.setName(roleEntity.getName());
        return roleDTO;
    }
    public static RoleEntity dTOToEntity(RoleDTO roleDTO){
        RoleEntity roleEntity=new RoleEntity();
        roleEntity.setName(roleDTO.getName());
        roleEntity.setRoleId(roleDTO.getRoleId());
        return roleEntity;

    }
}