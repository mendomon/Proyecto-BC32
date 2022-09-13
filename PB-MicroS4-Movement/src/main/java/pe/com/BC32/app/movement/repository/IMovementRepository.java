package pe.com.BC32.app.movement.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import pe.com.BC32.app.movement.entity.Movement;

public interface IMovementRepository extends ReactiveMongoRepository<Movement, String> {
}
