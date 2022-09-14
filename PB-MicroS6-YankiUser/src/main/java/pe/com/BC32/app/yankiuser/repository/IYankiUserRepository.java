package pe.com.BC32.app.yankiuser.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import pe.com.BC32.app.yankiuser.entity.YankiUser;

public interface IYankiUserRepository  extends ReactiveMongoRepository<YankiUser, String> {
}
