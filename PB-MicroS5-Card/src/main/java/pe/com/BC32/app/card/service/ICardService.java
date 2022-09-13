package pe.com.BC32.app.card.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICardService<CardDto, I> {
    Flux<CardDto> findAll();
    Mono<CardDto> findById(I id);
    Mono<CardDto> save(Mono<CardDto> dto);
    Mono<CardDto> update(Mono<CardDto> dto, I id);
    Mono<Void> delete(I id);
}
