package pe.com.BC32.app.card;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ICardRepository extends ReactiveMongoRepository<Card, String> {
}
