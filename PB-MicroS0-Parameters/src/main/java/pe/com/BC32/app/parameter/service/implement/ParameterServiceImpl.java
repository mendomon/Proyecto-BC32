package pe.com.BC32.app.parameter.service.implement;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.BC32.app.parameter.dto.ParameterDto;
import pe.com.BC32.app.parameter.mapper.ParameterMapper;
import pe.com.BC32.app.parameter.repository.IParameterRepository;
import pe.com.BC32.app.parameter.service.IParameterService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Slf4j
@Service
public class ParameterServiceImpl implements IParameterService<ParameterDto, String>{

    @Autowired
    protected IParameterRepository repository;
    @Autowired
    protected ParameterMapper mapper;

    @Override
    public Flux<ParameterDto> findAll(){
        return repository.findAll()
                .map(mapper::entityToDto);
    }
    @Override
    public Mono<ParameterDto> findById(String id) {
        return repository.findById(id)
                .map(mapper::entityToDto);
    }
    @Override
    public Flux<ParameterDto> findByParamNumber(String paramNumber){
        return repository.findByParamNumber(paramNumber)
                .map(mapper::entityToDto);
    }
    @Override
    public Mono<ParameterDto> save(@NotNull Mono<ParameterDto> dto){
        return dto.map(mapper::dtoToEntity)
                .flatMap(repository::save)
                .map(mapper::entityToDto);
    }
    @Override
    public Mono<ParameterDto> update(Mono<ParameterDto> dto, String id){
        return repository.findById(id)
                .flatMap(m -> dto.map(mapper::dtoToEntity)
                        .doOnNext(e -> e.setId(id)))
                .flatMap(repository::save)
                .map(mapper::entityToDto);
    }
    @Override
    public Mono<Void> delete(String id) {
        return repository.deleteById(id);
    }
}
