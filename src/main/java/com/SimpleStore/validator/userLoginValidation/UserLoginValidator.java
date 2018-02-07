package com.SimpleStore.validator.userLoginValidation;


import com.SimpleStore.Dao.UserDao;
import com.SimpleStore.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import com.SimpleStore.validator.Validator;
import com.SimpleStore.validator.user.UserException;

/**
 * Created by HOME on 15.06.2017.
 */
@Component
public class UserLoginValidator implements Validator{

    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public void validate(Object o) throws Exception {

        User user = (User) o;

        if(user.getName().isEmpty()){
            throw new UserException(UserLoginValidationMassages.EMPTY_USERNAME_FIELD);
        }else if(userDao.findByName(user.getName()) == null){
            throw new UserException(UserLoginValidationMassages.WRONG_USERNAME_OR_PASSWORD);
        }else if(encoder.matches(user.getPassword(),
                userDao.findByName(user.getName()).getPassword())){
            throw new UserException(UserLoginValidationMassages.WRONG_USERNAME_OR_PASSWORD);
        }


    }
}
