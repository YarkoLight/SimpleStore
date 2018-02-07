package com.SimpleStore.validator.user;

import com.SimpleStore.Dao.UserDao;
import com.SimpleStore.Entity.User;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.SimpleStore.validator.Validator;


/**
 * Created by HOME on 15.06.2017.
 */
@Component
public class UserValidator implements Validator{

    @Autowired
    private UserDao userDao;

    @Override
    public void validate(Object o) throws Exception {

        User user = (User) o;

        if (user.getName().isEmpty()){
            throw new UserException(UserValidationMassages.EMPTY_USERNAME_FIELD);
        }else if(userDao.findByName(user.getName()) != null){
            throw new UserException(UserValidationMassages.USERNAME_ALREADY_EXIST);
        }else if(user.getEmail().isEmpty()){
            throw new UserException(UserValidationMassages.EMPTY_EMAIL_FIELD);
        }else if(!user.getEmail().contains("@")){
            throw new UserException(UserValidationMassages.WRONG_EMAIL);
        }else if(userDao.findByEmail(user.getEmail()) != null){
            throw new UserException(UserValidationMassages.EMAIL_ALREADY_EXIST);
        }else if(user.getPassword().isEmpty()){
            throw new UserException(UserValidationMassages.EMPTY_PASSWORD_FIELD);
        }
    }
}
