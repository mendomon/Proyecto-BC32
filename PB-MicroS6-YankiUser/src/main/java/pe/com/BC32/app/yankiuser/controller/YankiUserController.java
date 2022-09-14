package pe.com.BC32.app.yankiuser.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.BC32.app.yankiuser.dto.YankiUserDto;
import pe.com.BC32.app.yankiuser.service.IYankiUserService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/yankiusers")
public class YankiUserController {

    @Autowired
    protected IYankiUserService service;

    @GetMapping(value = "/getall")
    public Flux<YankiUserDto> getall(){
        log.debug("Entering getall yankiusers " + this.getClass().getName());
        return service.findAll();
    }

    @GetMapping(value = "/get/{id}")
    public Mono<YankiUserDto> get(@PathVariable String id){
        log.debug("Entering get yankiuser " + this.getClass().getName());
        return service.findById(id);
    }

    @PostMapping(value = "/add")
    public Mono<YankiUserDto> add(@RequestBody Mono<YankiUserDto> dto){
        log.debug("Entering add yankiuser " + this.getClass().getName());
        return service.save(dto);
    }

    @PutMapping(value = "/update/{id}")
    public Mono<YankiUserDto> update(@RequestBody Mono<YankiUserDto> dto, @PathVariable String id){
        log.debug("Entering update yankiuser " + this.getClass().getName());
        return service.update(dto, id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public Mono<Void> delete(@PathVariable String id) {
        log.debug("Entering delete yankiuser " + this.getClass().getName());
        return service.delete(id);
    }
}
