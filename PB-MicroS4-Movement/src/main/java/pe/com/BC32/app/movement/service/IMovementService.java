package pe.com.BC32.app.movement.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IMovementService<MovementDto, I> {
    Flux<MovementDto> findAll();
    Mono<MovementDto> findById(I id);
    Mono<MovementDto> save(Mono<MovementDto> dto);
    Mono<MovementDto> update(Mono<MovementDto> dto, I id);
    Mono<Void> delete(I id);
}
