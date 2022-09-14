package pe.com.BC32.app.yankiuser.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IYankiUserService<YankiUserDto, I> {

    Flux<YankiUserDto> findAll();
    Mono<YankiUserDto> findById(I id);
    Mono<YankiUserDto> save(Mono<YankiUserDto> dto);
    Mono<YankiUserDto> update(Mono<YankiUserDto> dto, I id);
    Mono<Void> delete(I id);
}
