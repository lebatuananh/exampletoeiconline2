package vn.mra.core.service.impl;

import vn.mra.core.dao.UserDao;
import vn.mra.core.daoimpl.UserDaoImpl;
import vn.mra.core.dto.UserDTO;
import vn.mra.core.peristence.entity.UserEntity;
import vn.mra.core.service.UserService;
import vn.mra.core.utils.UserBeanUtils;

public class UserServiceImpl implements UserService {


    public UserDTO isUserExist(UserDTO userDTO) {
        UserDao userDao=new UserDaoImpl();
        UserEntity userEntity=userDao.isUserExist(userDTO.getName(),userDTO.getPassword());
        return UserBeanUtils.entityToDTO(userEntity);
    }

    public UserDTO findRoleByUser(UserDTO userDTO) {
        UserDao userDao=new UserDaoImpl();
        UserEntity userEntity=userDao.findRoleByUser(userDTO.getName(),userDTO.getPassword());
        return UserBeanUtils.entityToDTO(userEntity);
    }
}