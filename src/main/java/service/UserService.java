package service;

import form.UserRegistrationForm;
import model.User;

/**
 * Created by Andrey on 23.04.2017.
 */
public interface UserService {

    User saveNewUser(UserRegistrationForm form);

    User confirmUser(long id, String token);
}
