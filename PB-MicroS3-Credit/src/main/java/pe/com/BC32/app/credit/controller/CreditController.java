package pe.com.BC32.app.credit.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.BC32.app.credit.dto.CreditDto;
import pe.com.BC32.app.credit.service.ICreditService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/credits")
public class CreditController {

    @Autowired
    protected ICreditService service;

    @GetMapping(value = "/getall")
    public Flux<CreditDto> getAll(){
        log.debug("Entering getAll accounts " + this.getClass().getName());
        return service.findAll();
    }

    @GetMapping(value = "/get/{id}")
    public Mono<CreditDto> get(@PathVariable String id){
        log.debug("Entering get account " + this.getClass().getName());
        return service.findById(id);
    }

    @PostMapping(value = "/add")
    public Mono<CreditDto> add(@RequestBody Mono<CreditDto> dto){
        log.debug("Entering add account " + this.getClass().getName());
        return service.save(dto);
    }

    @PutMapping(value = "/update/{id}")
    public Mono<CreditDto> update(@RequestBody Mono<CreditDto> dto, @PathVariable String id){
        log.debug("Entering update account " + this.getClass().getName());
        return service.update(dto, id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public Mono<Void> delete(@PathVariable String id){
        log.debug("Entering delete account " + this.getClass().getName());
        return service.delete(id);
    }
}
