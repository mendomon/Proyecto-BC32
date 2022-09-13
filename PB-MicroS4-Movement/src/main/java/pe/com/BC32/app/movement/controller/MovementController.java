package pe.com.BC32.app.movement.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.BC32.app.movement.dto.MovementDto;
import pe.com.BC32.app.movement.service.IMovementService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/movements")
public class MovementController {

    @Autowired
    protected IMovementService service;

    @GetMapping(value = "/getall")
    public Flux<MovementDto> getAll(){
        log.debug("Entering getAll accounts " + this.getClass().getName());
        return service.findAll();
    }

    @GetMapping(value = "/get/{id}")
    public Mono<MovementDto> get(@PathVariable String id){
        log.debug("Entering get account " + this.getClass().getName());
        return service.findById(id);
    }

    @PostMapping(value = "/add")
    public Mono<MovementDto> add(@RequestBody Mono<MovementDto> dto){
        log.debug("Entering add account " + this.getClass().getName());
        return service.save(dto);
    }

    @PutMapping(value = "/update/{id}")
    public Mono<MovementDto> update(@RequestBody Mono<MovementDto> dto, @PathVariable String id){
        log.debug("Entering update account " + this.getClass().getName());
        return service.update(dto, id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public Mono<Void> delete(@PathVariable String id){
        log.debug("Entering delete account " + this.getClass().getName());
        return service.delete(id);
    }
}
