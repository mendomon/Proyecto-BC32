package pe.com.BC32.app.parameter.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IParameterService<ParameterDto, I> {

    Flux<ParameterDto> findAll();
    Mono<ParameterDto> findById(I id);
    Flux<ParameterDto> findByParamNumber(I paramNumber);
    Mono<ParameterDto> save(Mono<ParameterDto> dto);
    Mono<ParameterDto> update(Mono<ParameterDto> dto, I id);
    Mono<Void> delete(I id);
}
