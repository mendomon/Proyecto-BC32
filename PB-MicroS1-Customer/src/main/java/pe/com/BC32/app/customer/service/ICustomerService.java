package pe.com.BC32.app.customer.service;

import pe.com.BC32.app.customer.entity.Account;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICustomerService<CustomerDto, I> {

    Flux<CustomerDto> findAll();
    Mono<CustomerDto> findById(I id);
    Flux<CustomerDto> findByDocumentNumber(I documentNumber);
    Flux<CustomerDto> findByDocumentNumberDocumentType(
            I documentNumber, I documentType);
    Mono<CustomerDto> save(Mono<CustomerDto> dto);
    Mono<CustomerDto> update(Mono<CustomerDto> dto, I id);
    Mono<Void> delete(I id);

    //Account Methods
    Flux<Account> findAccountsByCustomerId(String id);
}
