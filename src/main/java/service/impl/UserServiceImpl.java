package service.impl;

import form.UserRegistrationForm;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserRepository;
import service.UserService;
import util.UserRegistrationFormToUser;

/**
 * Created by Andrey on 23.04.2017.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public void saveNewUser(UserRegistrationForm form) {
        User user = UserRegistrationFormToUser.transform(form);
        userRepository.save(user);
    }
}
