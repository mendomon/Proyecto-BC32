package pe.com.BC32.app.credit.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICreditService<CreditDto, I> {
    Flux<CreditDto> findAll();
    Mono<CreditDto> findById(I id);
    Mono<CreditDto> save(Mono<CreditDto> dto);
    Mono<CreditDto> update(Mono<CreditDto> dto, I id);
    Mono<Void> delete(I id);
}
