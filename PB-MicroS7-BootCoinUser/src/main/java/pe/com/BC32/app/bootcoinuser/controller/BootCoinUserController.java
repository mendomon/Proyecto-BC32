package pe.com.BC32.app.bootcoinuser.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.BC32.app.bootcoinuser.dto.BootCoinUserDto;
import pe.com.BC32.app.bootcoinuser.service.IBootCoinUserService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/bootcoinusers")
public class BootCoinUserController {

    @Autowired
    protected IBootCoinUserService service;

    @GetMapping(value = "/getall")
    public Flux<BootCoinUserDto> getall(){
        log.debug("Entering getall bootcoinusers " + this.getClass().getName());
        return service.findAll();
    }

    @GetMapping(value = "/get/{id}")
    public Mono<BootCoinUserDto> get(@PathVariable String id){
        log.debug("Entering get bootcoinuser " + this.getClass().getName());
        return service.findById(id);
    }

    @PostMapping(value = "/add")
    public Mono<BootCoinUserDto> add(@RequestBody Mono<BootCoinUserDto> dto){
        log.debug("Entering add bootcoinuser " + this.getClass().getName());
        return service.save(dto);
    }

    @PutMapping(value = "/update/{id}")
    public Mono<BootCoinUserDto> update(@RequestBody Mono<BootCoinUserDto> dto, @PathVariable String id){
        log.debug("Entering update bootcoinuser " + this.getClass().getName());
        return service.update(dto, id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public Mono<Void> delete(@PathVariable String id) {
        log.debug("Entering delete bootcoinuser " + this.getClass().getName());
        return service.delete(id);
    }
}
