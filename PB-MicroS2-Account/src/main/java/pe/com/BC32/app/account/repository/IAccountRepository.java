package pe.com.BC32.app.account.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import pe.com.BC32.app.account.entity.Account;

public interface IAccountRepository extends ReactiveMongoRepository<Account, String> {

    //@Query("{'accountType': ?0, 'balance': { $mt: ?1}")
}
