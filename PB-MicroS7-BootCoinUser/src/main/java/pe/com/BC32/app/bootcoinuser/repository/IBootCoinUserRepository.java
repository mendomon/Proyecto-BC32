package pe.com.BC32.app.bootcoinuser.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import pe.com.BC32.app.bootcoinuser.entity.BootCoinUser;

public interface IBootCoinUserRepository  extends ReactiveMongoRepository<BootCoinUser, String> {
}
