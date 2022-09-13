package pe.com.BC32.app.customer.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import pe.com.BC32.app.customer.entity.Customer;
import reactor.core.publisher.Flux;

public interface ICustomerRepository extends ReactiveMongoRepository<Customer, String> {

    @Query("{'documentNumber': ?0}")
    Flux<Customer> findByDocumentNumber(String documentNumber);

    @Query("{'documentNumber': ?0, 'documentType': ?1}")
    Flux<Customer> findByDocumentNumberDocumentType(
            String documentNumber, String documentType);

}
