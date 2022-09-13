package pe.com.BC32.app.account.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import pe.com.BC32.app.account.dto.AccountDto;
import pe.com.BC32.app.account.service.IAccountService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    protected IAccountService service;

    @Value("${prueba.string}")
    private String strFromConfigServer;

    @GetMapping(value = "/getall")
    public Flux<AccountDto> getAll(){
        log.debug("Entering getAll accounts " + this.getClass().getName());
        log.debug("strFromConfigServer value " + strFromConfigServer);
        return service.findAll();
    }

    @GetMapping(value = "/get/{id}")
    public Mono<AccountDto> get(@PathVariable String id){
        log.debug("Entering get account " + this.getClass().getName());
        return service.findById(id);
    }

    @PostMapping(value = "/add")
    public Mono<AccountDto> add(@RequestBody Mono<AccountDto> dto){
        log.debug("Entering add account " + this.getClass().getName());
        return service.save(dto);
    }

    @PutMapping(value = "/update/{id}")
    public Mono<AccountDto> update(@RequestBody Mono<AccountDto> dto, @PathVariable String id){
        log.debug("Entering update account " + this.getClass().getName());
        return service.update(dto, id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public Mono<Void> delete(@PathVariable String id){
        log.debug("Entering delete account " + this.getClass().getName());
        return service.delete(id);
    }
}
