package org.spring.utill;

import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.spring.entityBi.Diary;
import org.spring.entityBi.Section;
import org.spring.entityBi.User;


public class HibernateUtil {

    @Getter
    private static final SessionFactory sessionFactory  = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        return new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Diary.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();
    }

    public static void shutdown(){
        getSessionFactory().close();
    }
}
