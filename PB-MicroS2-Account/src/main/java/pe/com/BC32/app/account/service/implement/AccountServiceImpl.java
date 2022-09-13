package pe.com.BC32.app.account.service.implement;

import java.time.LocalDateTime;
import java.time.ZoneId;
import org.jetbrains.annotations.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pe.com.BC32.app.account.dto.AccountDto;
import pe.com.BC32.app.account.mapper.AccountMapper;
import pe.com.BC32.app.account.repository.IAccountRepository;
import pe.com.BC32.app.account.service.IAccountService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class AccountServiceImpl implements IAccountService<AccountDto, String> {

    @Autowired
    protected IAccountRepository repository;
    @Autowired
    protected AccountMapper mapper;

    @Value("${user.currentuser}")
    private String currentUser;

    @Override
    public Flux<AccountDto> findAll(){
        return repository.findAll().map(mapper::entityToDto);
    }

    @Override
    public Mono<AccountDto> findById(String id){
        return repository.findById(id).map(mapper::entityToDto);
    }

    @Override
    public Mono<AccountDto> save(@NotNull Mono<AccountDto> dto){
        log.debug("Entering save " + this.getClass().getName());
        return dto.map(mapper::dtoToEntity)
                .doOnSuccess(e->e.setCreatedAt(LocalDateTime.now(ZoneId.of("America/Lima"))))
                .doOnSuccess(e->e.setCreatedBy(currentUser))
                .flatMap(repository::save)
                .map(mapper::entityToDto);
    }

    @Override
    public Mono<AccountDto> update(Mono<AccountDto> dto, String id){
        log.debug("Entering update " + this.getClass().getName());
        return repository.findById(id)
                .flatMap(m -> dto.map(mapper::dtoToEntity)
                        .doOnNext(e->e.setId(id)))
                .doOnSuccess(e->e.setUpdatedAt(LocalDateTime.now(ZoneId.of("America/Lima"))))
                .doOnSuccess(e->e.setUpdatedBy(currentUser))
                .flatMap(repository::save)
                .map(mapper::entityToDto);
    }

    @Override
    public Mono<Void> delete(String id) {
        return repository.deleteById(id);
    }
}
