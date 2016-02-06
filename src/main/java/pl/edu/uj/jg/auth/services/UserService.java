package pl.edu.uj.jg.auth.services;

import pl.edu.uj.jg.auth.domain.User;
import pl.edu.uj.jg.auth.domain.UserCreateForm;

import java.util.Collection;
import java.util.Optional;

public interface UserService {

    Optional<User> getUserById(long id);

    Optional<User> getUserByEmail(String email);

    Collection<User> getAllUsers();

    User create(UserCreateForm form);
}
