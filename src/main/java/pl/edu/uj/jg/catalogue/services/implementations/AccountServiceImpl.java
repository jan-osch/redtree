package pl.edu.uj.jg.catalogue.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.uj.jg.auth.domain.User;
import pl.edu.uj.jg.auth.repositories.UserRepository;
import pl.edu.uj.jg.catalogue.domain.social.Account;
import pl.edu.uj.jg.catalogue.repositories.AccountRepository;
import pl.edu.uj.jg.catalogue.services.AccountService;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepository;
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setAccountRepository(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account createAccountForUser(User user, String name) {
        Account account = new Account();
        account.setName(name);
        account = accountRepository.save(account);
        user.setAccount(account);
        userRepository.save(user);
        return account;
    }
}
