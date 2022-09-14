package pe.com.BC32.app.card.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import pe.com.BC32.app.card.entity.Card;

public interface ICardRepository extends ReactiveMongoRepository<Card, String> {
}
