package pl.edu.uj.jg.catalogue.services;

import pl.edu.uj.jg.auth.domain.User;
import pl.edu.uj.jg.catalogue.domain.social.Account;

public interface AccountService {
    Account createAccountForUser(User user, String name);
}
