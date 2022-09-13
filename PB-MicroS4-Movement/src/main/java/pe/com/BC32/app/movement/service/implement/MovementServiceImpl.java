package pe.com.BC32.app.movement.service.implement;

import java.time.LocalDateTime;
import java.time.ZoneId;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Service;
import pe.com.BC32.app.movement.dto.MovementDto;
import pe.com.BC32.app.movement.mapper.MovementMapper;
import pe.com.BC32.app.movement.repository.IMovementRepository;
import pe.com.BC32.app.movement.service.IMovementService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class MovementServiceImpl implements IMovementService<MovementDto, String> {

    @Autowired
    protected IMovementRepository repository;
    @Autowired
    protected MovementMapper mapper;

    @Value("${user.currentuser}")
    private String currentUser;

    @Override
    public Flux<MovementDto> findAll(){
        return repository.findAll().map(mapper::entityToDto);
    }

    @Override
    @Query("{'id': ?0}")
    public Mono<MovementDto> findById(String id){
        return repository.findById(id).map(mapper::entityToDto);
    }
    @Override
    public Mono<MovementDto> save(@NotNull Mono<MovementDto> dto){
        log.debug("Entering save " + this.getClass().getName());
        return dto.map(mapper::dtoToEntity)
                .doOnSuccess(e->e.setCreatedAt(LocalDateTime.now(ZoneId.of("America/Lima"))))
                .doOnSuccess(e->e.setCreatedBy(currentUser))
                .flatMap(repository::save)
                .map(mapper::entityToDto);
    }

    @Override
    public Mono<MovementDto> update(Mono<MovementDto> dto, String id){
        log.debug("Entering update " + this.getClass().getName());
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
