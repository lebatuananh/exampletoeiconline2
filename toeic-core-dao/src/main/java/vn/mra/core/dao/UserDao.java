package vn.mra.core.dao;

import vn.mra.core.data.dao.GenericDao;
import vn.mra.core.peristence.entity.UserEntity;

public interface UserDao extends GenericDao<Integer, UserEntity> {
     UserEntity isUserExist(String name,String password);
     UserEntity findRoleByUser(String name, String password);
}