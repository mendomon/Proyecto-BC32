package pe.com.BC32.app.customer.service.implement;

import org.jetbrains.annotations.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import pe.com.BC32.app.customer.dto.CustomerDto;
import pe.com.BC32.app.customer.entity.Account;
import pe.com.BC32.app.customer.mapper.CustomerMapper;
import pe.com.BC32.app.customer.repository.ICustomerRepository;
import pe.com.BC32.app.customer.service.ICustomerService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Slf4j
@Service
public class CustomerServiceImpl implements ICustomerService<CustomerDto, String> {

    @Autowired
    protected ICustomerRepository repository;
    @Autowired
    protected CustomerMapper mapper;

    @Value("${user.currentuser}")
    private String currentUser;

    @Override
    public Flux<CustomerDto> findAll(){
        return repository.findAll()
                .map(mapper::entityToDto);
    }
    @Override
    public Mono<CustomerDto> findById(String id) {
        return repository.findById(id)
                .map(mapper::entityToDto);
    }
    @Override
    public Flux<CustomerDto> findByDocumentNumber(String documentNumber){
        return repository.findByDocumentNumber(documentNumber)
                .map(mapper::entityToDto);
    }
    @Override
    public Flux<CustomerDto> findByDocumentNumberDocumentType(String documentNumber, String documentType){
        return repository.findByDocumentNumberDocumentType(documentNumber, documentType)
                .map(mapper::entityToDto);
    }
    @Override
    public Mono<CustomerDto> save(@NotNull Mono<CustomerDto> dto){
        return dto.map(mapper::dtoToEntity)
                .doOnSuccess(e->e.setCreatedAt(LocalDateTime.now(ZoneId.of("America/Lima"))))
                .doOnSuccess(e->e.setCreatedBy(currentUser))
                .doOnSuccess(e->e.setUpdatedAt(null))
                .doOnSuccess(e->e.setUpdatedBy(null))
                .flatMap(repository::save)
                .map(mapper::entityToDto);
    }
    @Override
    public Mono<CustomerDto> update(Mono<CustomerDto> dto, String id){
        return repository.findById(id)
                .flatMap(m -> dto.map(mapper::dtoToEntity)
                        .doOnNext(e -> e.setId(id))
                        .doOnSuccess(e->e.setUpdatedAt(LocalDateTime.now(ZoneId.of("America/Lima"))))
                        .doOnSuccess(e->e.setUpdatedBy(currentUser)))
                .flatMap(repository::save)
                .map(mapper::entityToDto);
    }
    @Override
    public Mono<Void> delete(String id) {
        return repository.deleteById(id);
    }

    //Account Methods
    private final WebClient webClient;

    public CustomerServiceImpl(WebClient.Builder webClientBuilder){
        this.webClient = webClientBuilder.baseUrl("http://localhost:9089").build();
    }

    @Override
    public Flux<Account> findAccountsByCustomerId(String id) {
        //Account account = new Account();
        //Flux<Account> accountByCustomer = this.webClient.get().uri("/accounts/{id}"), id).retrieve().bodyToFlux(Account.class);

        return this.webClient.get().uri("/accounts/{id}", id).retrieve().bodyToFlux(Account.class);

    };
}
