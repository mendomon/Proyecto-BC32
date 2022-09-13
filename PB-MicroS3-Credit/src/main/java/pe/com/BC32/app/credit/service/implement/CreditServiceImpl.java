package pe.com.BC32.app.credit.service.implement;

import java.time.LocalDateTime;
import java.time.ZoneId;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Service;
import pe.com.BC32.app.credit.dto.CreditDto;
import pe.com.BC32.app.credit.mapper.CreditMapper;
import pe.com.BC32.app.credit.repository.ICreditRepository;
import pe.com.BC32.app.credit.service.ICreditService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class CreditServiceImpl implements ICreditService<CreditDto, String> {

    @Autowired
    protected ICreditRepository repository;
    @Autowired
    protected CreditMapper mapper;

    @Value("${user.currentuser}")
    private String currentUser;

    @Override
    public Flux<CreditDto> findAll(){
        return repository.findAll().map(mapper::entityToDto);
    }

    @Override
    @Query("{'id': ?0}")
    public Mono<CreditDto> findById(String id){
        return repository.findById(id).map(mapper::entityToDto);
    }

    @Override
    public Mono<CreditDto> save(@NotNull Mono<CreditDto> dto){
        log.debug("Entering save " + this.getClass().getName());
        return dto.map(mapper::dtoToEntity)
                .doOnSuccess(e->e.setCreatedAt(LocalDateTime.now(ZoneId.of("America/Lima"))))
                .doOnSuccess(e->e.setCreatedBy(currentUser))
                .doOnSuccess(e->e.setUpdatedAt(null))
                .doOnSuccess(e->e.setUpdatedBy(null))
                .flatMap(repository::save)
                .map(mapper::entityToDto);
    }

    @Override
    public Mono<CreditDto> update(Mono<CreditDto> dto, String id){
        log.debug("Entering update " + this.getClass().getName());
        return repository.findById(id)
                .flatMap(m -> dto.map(mapper::dtoToEntity)
                        .doOnNext(e -> e.setId(id))
                        //.doOnSuccess(e->e.setCreatedAt(e.getCreatedAt()))
                        //.doOnSuccess(e->e.setCreatedBy(e.getCreatedBy()))
                        .doOnSuccess(e->e.setUpdatedAt(LocalDateTime.now(ZoneId.of("America/Lima"))))
                        .doOnSuccess(e->e.setUpdatedBy(currentUser)))
                .flatMap(repository::save)
                .map(mapper::entityToDto);
    }

    @Override
    public Mono<Void> delete(String id) {
        return repository.deleteById(id);
    }
}
