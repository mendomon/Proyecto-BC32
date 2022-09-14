package pe.com.BC32.app.card.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.BC32.app.card.dto.CardDto;
import pe.com.BC32.app.card.service.ICardService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/cards")
public class CardController {

    @Autowired
    protected ICardService service;

    @GetMapping(value = "/getall")
    public Flux<CardDto> getAll(){
        log.debug("Entering getAll cards " + this.getClass().getName());
        return service.findAll();
    }

    @GetMapping(value = "/get/{id}")
    public Mono<CardDto> get(@PathVariable String id){
        log.debug("Entering get cards " + this.getClass().getName());
        return service.findById(id);
    }

    @PostMapping(value = "/add")
    public Mono<CardDto> add(@RequestBody Mono<CardDto> dto){
        log.debug("Entering add cards " + this.getClass().getName());
        return service.save(dto);
    }

    @PutMapping(value = "/update/{id}")
    public Mono<CardDto> update(@RequestBody Mono<CardDto> dto, @PathVariable String id){
        log.debug("Entering update cards " + this.getClass().getName());
        return service.update(dto, id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public Mono<Void> delete(@PathVariable String id){
        log.debug("Entering delete cards " + this.getClass().getName());
        return service.delete(id);
    }
}
