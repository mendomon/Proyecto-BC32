package pe.com.BC32.app.card.service.implement;

import java.time.LocalDateTime;
import java.time.ZoneId;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.BC32.app.card.CardDto;
import pe.com.BC32.app.card.CardMapper;
import pe.com.BC32.app.card.ICardRepository;
import pe.com.BC32.app.card.service.ICardService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class CardServiceImpl implements ICardService<CardDto, String> {

    @Autowired
    protected ICardRepository repository;
    @Autowired
    protected CardMapper mapper;

    @Override
    public Flux<CardDto> findAll(){
        return repository.findAll().map(mapper::entityToDto);
    }

    @Override
    public Mono<CardDto> findById(String id){
        return repository.findById(id).map(mapper::entityToDto);
    }

    @Override
    public Mono<CardDto> save(@NotNull Mono<CardDto> dto){
        log.debug("Entering save " + this.getClass().getName());
        return dto.map(mapper::dtoToEntity)
                .doOnSuccess(e->e.setCreatedAt(LocalDateTime.now(ZoneId.of("America/Lima"))))
                .flatMap(repository::save)
                .map(mapper::entityToDto);
    }

    @Override
    public Mono<CardDto> update(Mono<CardDto> dto, String id){
        log.debug("Entering update " + this.getClass().getName());
        return repository.findById(id)
                .flatMap(m -> dto.map(mapper::dtoToEntity)
                        .doOnNext(e->e.setId(id)))
                .flatMap(repository::save)
                .map(mapper::entityToDto);
    }
    @Override
    public Mono<Void> delete(String id) {
        return repository.deleteById(id);
    }
}
