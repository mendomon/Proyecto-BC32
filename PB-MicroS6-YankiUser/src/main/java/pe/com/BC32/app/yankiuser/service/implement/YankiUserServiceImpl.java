package pe.com.BC32.app.yankiuser.service.implement;

import java.time.LocalDateTime;
import java.time.ZoneId;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pe.com.BC32.app.yankiuser.dto.YankiUserDto;
import pe.com.BC32.app.yankiuser.mapper.YankiUserMapper;
import pe.com.BC32.app.yankiuser.repository.IYankiUserRepository;
import pe.com.BC32.app.yankiuser.service.IYankiUserService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class YankiUserServiceImpl implements IYankiUserService<YankiUserDto, String> {

    @Autowired
    protected IYankiUserRepository repository;
    @Autowired
    protected YankiUserMapper mapper;

    @Value("${user.currentuser}")
    private String currentUser;

    @Override
    public Flux<YankiUserDto> findAll(){
        return repository.findAll().map(mapper::entityToDto);
    }

    @Override
    public Mono<YankiUserDto> findById(String id){
        return repository.findById(id).map(mapper::entityToDto);
    }

    @Override
    public Mono<YankiUserDto> save(@NotNull Mono<YankiUserDto> dto){
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
    public Mono<YankiUserDto> update(Mono<YankiUserDto> dto, String id){
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
