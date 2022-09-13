package pe.com.BC32.app.customer.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import pe.com.BC32.app.customer.dto.CustomerDto;
import pe.com.BC32.app.customer.entity.Account;
import pe.com.BC32.app.customer.service.ICustomerService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    protected ICustomerService service;

    @Value("${prueba.string}")
    private String strFromConfigServer;

    @GetMapping(value = "/getall")
    public Flux<CustomerDto> getall(){
        log.debug("Entering getall customers " + this.getClass().getName());
        log.debug("strFromConfigServer value " + strFromConfigServer);
        return service.findAll();
    }

    @GetMapping(value = "/get/{id}")
    public Mono<CustomerDto> get(@PathVariable String id){
        log.debug("Entering get customer " + this.getClass().getName());
        return service.findById(id);
    }

    @GetMapping(value = "/getbydn/{documentNumber}")
    public Flux<CustomerDto> getByDocumentNumber(@PathVariable String documentNumber) {
        log.debug("Entering getByDocumentNumber customer " + this.getClass().getName());
        return service.findByDocumentNumber(documentNumber);
    };

    @GetMapping(value = "/getbydndt/{documentNumber}/{documentType}")
    public Flux<CustomerDto> getByDocumentNumberDocumentType(
            @PathVariable String documentNumber,
            @PathVariable String documentType) {
        log.debug("Entering getByDocumentNumberDocumentType customer " + this.getClass().getName());
        return service.findByDocumentNumberDocumentType(documentNumber, documentType);
    }

    @PostMapping(value = "/add")
    public Mono<CustomerDto> add(@RequestBody Mono<CustomerDto> dto){
        log.debug("Entering add customer " + this.getClass().getName());
        return service.save(dto);
    }

    @PutMapping(value = "/update/{id}")
    public Mono<CustomerDto> update(@RequestBody Mono<CustomerDto> dto, @PathVariable String id){
        log.debug("Entering update customer " + this.getClass().getName());
        return service.update(dto, id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public Mono<Void> delete(@PathVariable String id) {
        log.debug("Entering delete customer " + this.getClass().getName());
        return service.delete(id);
    }

    //Account Methods
    @GetMapping("/getaccounts/{id}")
    @CircuitBreaker(name="accounts", fallbackMethod = "fallbackgetAccountsByCustomerId")
    public Flux<Account> getAccountsByCustomerId(@PathVariable String id) {
        return service.findAccountsByCustomerId(id);
    }

    public Mono<String> fallbackgetAccountsByCustomerId(String id, RuntimeException runtimeException) {
        return Mono.just("Microservice Account is not responding");
    }
}
