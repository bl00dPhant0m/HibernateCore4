package org.spring;

import org.spring.dao.UserDaoBi;
import org.spring.entityBi.Diary;
import org.spring.entityBi.User;
import org.spring.utill.HibernateUtil;

import java.time.LocalDate;
import java.util.List;

/**
 * Hello world!
 *
 */
public class AppBiDirection {
    public static void main( String[] args ) {

        Diary diary = new Diary("School", "Class");
        Diary diary2 = new Diary("School1", "Class3");
        Diary diary3 = new Diary("School2", "Class4");


        User user = new User( "Nikita", LocalDate.of(2000, 2, 25),diary);
        User user1 = new User( "Dima", LocalDate.of(1989, 12, 31), diary2);
        User user2 = new User( "Alina", LocalDate.of(1999, 5, 8), diary3);

        diary.setUser(user);
        diary2.setUser(user1);
        diary3.setUser(user2);
        diary3.getMarksOfRussia().add(5);
        diary3.getMarksOfRussia().add(4);
        diary3.getMarksOfRussia().add(3);
        diary3.getMarksOfRussia().add(2);

        UserDaoBi userDao = new UserDaoBi();
//        userDao.saveUser(user1);
//        userDao.saveUser(user);
        System.out.println(userDao.findUsers());

        User userFromTable = userDao.findUserById(1);
        System.out.println(userFromTable.getName());
        System.out.println(userFromTable.getDiary().getNameOfSchool());
        System.out.println("Оценки по русскому языку" + userFromTable.getDiary().getMarksOfRussia());
        System.out.println("Оценки по литературе" +userFromTable.getDiary().getMarksOfLiterature());
        System.out.println("Оценки по математике" +userFromTable.getDiary().getMarksOfMath());

        // userDao.saveUser(new User("Andrey", LocalDate.of(1990, 1, 25)));

        //userDao.deleteUser(2);
        //System.out.println(userDao.findUserById(3));
        //System.out.println(userDao.findUserById(1));

//        User userById = userDao.findUserById(4);
//        userById.setName(userById.getName()+"X");
//        userById.setDiary(diary3);
//        userDao.updateUser(userById);
//
        HibernateUtil.shutdown();

    }
}
