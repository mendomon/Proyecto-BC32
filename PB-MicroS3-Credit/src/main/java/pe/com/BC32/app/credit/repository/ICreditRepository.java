package pe.com.BC32.app.credit.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import pe.com.BC32.app.credit.entity.Credit;

public interface ICreditRepository extends ReactiveMongoRepository<Credit, String> {
}
