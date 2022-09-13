package pe.com.BC32.app.account.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IAccountService<AccountDto, I> {

    Flux<AccountDto> findAll();
    Mono<AccountDto> findById(I id);
    Mono<AccountDto> save(Mono<AccountDto> dto);
    Mono<AccountDto> update(Mono<AccountDto> dto, I id);
    Mono<Void> delete(I id);
}
