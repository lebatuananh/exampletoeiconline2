package vn.mra.core.api.test;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import vn.mra.core.dao.UserDao;
import vn.mra.core.daoimpl.UserDaoImpl;
import vn.mra.core.peristence.entity.UserEntity;



public class LoginTest {
    private final Logger log = Logger.getLogger(this.getClass());
    @Test
    public void checkIsUserExist(){
        UserDao userDao=new UserDaoImpl();
        String name="admin";
        String password="123456";
        UserEntity userEntity=userDao.isUserExist(name,password);
        if(userEntity!=null){
            log.error("login success");
        }else{
            log.error("login failed");
        }
    }
    @Test
    public void checkFindRoleByUser(){
        UserDao userDao=new UserDaoImpl();
        String name="admin";
        String password="123456";
        UserEntity userEntity=userDao.findRoleByUser(name,password);
        log.error(userEntity.getRole().getRoleId()+" - "+userEntity.getRole().getName());

    }
}