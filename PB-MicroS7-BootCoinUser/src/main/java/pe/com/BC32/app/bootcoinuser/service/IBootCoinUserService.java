package pe.com.BC32.app.bootcoinuser.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IBootCoinUserService<BootCoinUserDto, I> {

    Flux<BootCoinUserDto> findAll();
    Mono<BootCoinUserDto> findById(I id);
    Mono<BootCoinUserDto> save(Mono<BootCoinUserDto> dto);
    Mono<BootCoinUserDto> update(Mono<BootCoinUserDto> dto, I id);
    Mono<Void> delete(I id);
}
