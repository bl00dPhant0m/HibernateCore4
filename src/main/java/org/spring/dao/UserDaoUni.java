package org.spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.spring.entityUni.User;
import org.spring.utill.HibernateUtil;

public class UserDaoUni {
    //C
    public void saveUser(User user) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        currentSession.beginTransaction();

        currentSession.persist(user);

        currentSession.getTransaction().commit();
        currentSession.close();


    }

    //R
    public User findUserById(int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        currentSession.beginTransaction();
        User user =null;
        try {
            user =  currentSession.get(User.class, id);
            //System.out.println(user.getDiary());
            currentSession.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e);
        }  finally{
            currentSession.close();

        }
        return user;
    }

    //проверить
    public void updateUser(User user) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        currentSession.beginTransaction();
        try {
            currentSession.merge(user);
            currentSession.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e);
        }finally {
            currentSession.close();

        }

    }

    public void deleteUser(int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = null;
        try {
            currentSession = sessionFactory.openSession();
            currentSession.beginTransaction();

            User userToDelete = currentSession.get(User.class, id);
            if (userToDelete != null) {
                currentSession.remove(userToDelete);
            } else {
                System.out.println("User with id " + id + " not found.");
            }

            currentSession.getTransaction().commit();
        } catch (Exception e) {
            if (currentSession != null && currentSession.getTransaction().isActive()) {
                currentSession.getTransaction().rollback();
            }
            System.out.println("Error deleting user: " + e.getMessage());
        } finally {
            if (currentSession != null) {
                currentSession.close();
            }
            // HibernateUtil.shutdown(); // Не вызывайте shutdown() здесь, это может быть необходимо только при закрытии приложения
        }

    }
}
