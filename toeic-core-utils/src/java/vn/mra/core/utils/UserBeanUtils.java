package vn.mra.core.utils;

import vn.mra.core.dto.UserDTO;
import vn.mra.core.peristence.entity.UserEntity;

public class UserBeanUtils {
    public static UserDTO entityToDTO(UserEntity userEntity){
        UserDTO userDTO=new UserDTO();
        userDTO.setUserId(userEntity.getUserId());
        userDTO.setName(userEntity.getName());
        userDTO.setPassword(userEntity.getPassword());
        userDTO.setFullName(userEntity.getPassword());
        userDTO.setCreateDate(userEntity.getCreateDate());
        userDTO.setRoleDTO(RoleBeanUtils.entityToDTO(userEntity.getRole()));
        return userDTO;
    }
    public static UserEntity dTOToEntity(UserDTO userDTO){
        UserEntity userEntity=new UserEntity();
        userEntity.setUserId(userDTO.getUserId());
        userEntity.setName(userDTO.getName());
        userEntity.setPassword(userDTO.getPassword());
        userEntity.setFullName(userDTO.getPassword());
        userEntity.setCreateDate(userDTO.getCreateDate());
        userEntity.setRole(RoleBeanUtils.dTOToEntity(userDTO.getRoleDTO()));

        return userEntity;
    }
}