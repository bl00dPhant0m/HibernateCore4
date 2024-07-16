package org.spring;

import org.spring.dao.UserDaoUni;
import org.spring.entityUni.Diary;
import org.spring.entityUni.User;

import java.time.LocalDate;

public class AppUniDirection {
    public static void main(String[] args) {
        UserDaoUni userDao = new UserDaoUni();

        User user = new User("Nikolay", LocalDate.of(1995, 7, 3));
        Diary diary = new Diary("School 4", "Clas 5");
        user.setDiary(diary);



        System.out.println(userDao.findUserById(1));
    }
}
