package com.employee.dao;

import com.employee.entity.Employee;
import com.employee.utils.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class EmployeeDaoImpl  implements  EmployeeDao{
    Session session;
    @Override
    public String createOrUpdate(Employee model) {
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            session.beginTransaction();
            if (model.getId() == null){
                session.save(model);
            }else {
                session.update(model);
            }
            session.getTransaction().commit();
            return model.getFullname();
        }catch (Exception e){
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public List<Employee> getAll() {

            try {
                session = HibernateUtils.getSessionFactory().openSession();
                String query = " FROM Employee ";
                session.beginTransaction();
                List<Employee> list = session.createQuery(query).getResultList();
                return list;
            }catch (Exception e){
                e.getStackTrace();
                return  null;
            }finally {
                session.close();
            }
    }

    @Override
    public void deleteById(int id) {
        try{
            session = HibernateUtils.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("delete  from Employee where id = :id").setParameter("id",id);
            query.executeUpdate();
            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
    }
}
