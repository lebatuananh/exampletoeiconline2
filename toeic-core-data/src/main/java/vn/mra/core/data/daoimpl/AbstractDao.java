package vn.mra.core.data.daoimpl;

import org.hibernate.*;
import vn.mra.core.common.constant.CoreConstant;
import vn.mra.core.common.utils.HibernateUtils;
import vn.mra.core.data.dao.GenericDao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public class AbstractDao<ID extends Serializable,T> implements GenericDao<ID,T> {
    private Class<T>peristenceClass;

    public AbstractDao() {
        this.peristenceClass = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    //convert class to String
    public String getPeristenceClassName(){
        return peristenceClass.getSimpleName();
    }

    public List<T> findAll() {
        List<T>list=new ArrayList<T>();
        Transaction transaction=null;
        Session session=HibernateUtils.getSessionFactory().openSession();
        try {
            transaction=session.beginTransaction();
            //HQL
            StringBuilder sql=new StringBuilder("from ");
            sql.append(this.getPeristenceClassName());
            Query query=session.createQuery(sql.toString());
            list=query.list();
            transaction.commit();
        }catch (HibernateException e){
            transaction.rollback();
            throw e;
        }finally {
            session.close();
        }
        return list;
    }

    public T update(T entity) {
        Session session=HibernateUtils.getSessionFactory().openSession();
        Transaction transaction=null;
        T result=null;
        try{
            Object object=session.merge(entity);
            result= (T) object;
            transaction=session.beginTransaction();
            transaction.commit();
        }catch (HibernateException e){
            transaction.rollback();
            throw e;
        }finally {
            session.close();
        }
    return  result;
    }

    public void save(T entity) {
        Session session=HibernateUtils.getSessionFactory().openSession();
        Transaction transaction=null;
        try {
            session.persist(entity);
            transaction=session.beginTransaction();
            transaction.commit();

        }catch (HibernateException e){
            transaction.rollback();
            throw e;
        }finally {
            session.close();
        }
    }

    public T findById(ID id) {
        T result=null;
        Session session =HibernateUtils.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        try {
            result= (T) session.get(peristenceClass,id);
            if (result==null){
                throw new ObjectNotFoundException(" NOT FOUND "+id,null);
            }
            transaction.commit();

        }catch (HibernateException e){
            transaction.rollback();
            throw e;
        }finally {
            session.close();
        }
        return result;
    }

    public Object[] findByProperty(String property, Object value, String sortExpression, String sortDirection) {
        List<T>list=new ArrayList<T>();
        Object totalItems=0;
        Session session=HibernateUtils.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        try {
            StringBuilder sql1=new StringBuilder("from ");
            sql1.append(getPeristenceClassName());
            if (property!=null&&value!=null){
                sql1.append("where ").append(property).append("= :value");
            }
            if (sortDirection!=null&&sortExpression!=null){
                sql1.append(" order by ").append(sortExpression).append(" "+(sortDirection.equals(CoreConstant.SORT_ASC)?"asc":"desc"));
            }
            Query query1=session.createQuery(sql1.toString());
            if(value!=null){
                query1.setParameter("value",value);
            }
            list=query1.list();
            StringBuilder sql2=new StringBuilder("select count(*) from ");
            sql2.append(getPeristenceClassName());
            if (property!=null&&value!=null){
                sql1.append(" where ").append(property).append("= :value");
            }
            Query query2=session.createQuery(sql2.toString());
            if(value!=null){
                query2.setParameter("value",value);
            }
            totalItems = query2.list().get(0);
            transaction.commit();
        }catch (HibernateException e){
            transaction.rollback();
            throw e;
        }finally {
            session.close();
        }
        return new Object[]{totalItems, list};
    }

    public Integer delete(List<ID> ids) {
        Session session=HibernateUtils.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        Integer count=0;
        try{
            for (ID item:ids) {
                T t= (T) session.get(peristenceClass,item);
                session.delete(t);
                count++;
            }
            transaction.commit();
        }catch (HibernateException e){
            transaction.rollback();
        }finally {
            session.close();
        }
        return count;
    }
}