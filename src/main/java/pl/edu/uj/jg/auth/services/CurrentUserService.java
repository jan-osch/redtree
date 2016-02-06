package pl.edu.uj.jg.auth.services;


import pl.edu.uj.jg.auth.domain.CurrentUser;

public interface CurrentUserService {

    boolean canAccessUser(CurrentUser currentUser, Long userId);

}
