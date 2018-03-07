package vn.mra.core.daoimpl;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import vn.mra.core.common.utils.HibernateUtils;
import vn.mra.core.dao.UserDao;
import vn.mra.core.data.daoimpl.AbstractDao;
import vn.mra.core.peristence.entity.UserEntity;

public class UserDaoImpl extends AbstractDao<Integer,UserEntity>implements UserDao {
    public UserEntity isUserExist(String name, String password) {
        UserEntity userEntity=new UserEntity();
        Session session= HibernateUtils.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        try {
            StringBuilder sql=new StringBuilder("FROM UserEntity WHERE name= :name AND password= :password");
            Query query=session.createQuery(sql.toString());
            query.setParameter("name",name);
            query.setParameter("password",password);
            userEntity= (UserEntity) query.uniqueResult();
            transaction.commit();
        }catch (HibernateException e){
            transaction.rollback();
            throw e;
        }finally {
            session.close();
        }
        return userEntity;
    }

    public UserEntity findRoleByUser(String name, String password) {
        UserEntity userEntity=new UserEntity();
        Session session= HibernateUtils.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        try {
            StringBuilder sql=new StringBuilder("FROM UserEntity WHERE name= :name AND password= :password");
            Query query=session.createQuery(sql.toString());
            query.setParameter("name",name);
            query.setParameter("password",password);
            userEntity= (UserEntity) query.uniqueResult();
            transaction.commit();
        }catch (HibernateException e){
            transaction.rollback();
            throw e;
        }finally {
            session.close();
        }
        return userEntity;
    }
}