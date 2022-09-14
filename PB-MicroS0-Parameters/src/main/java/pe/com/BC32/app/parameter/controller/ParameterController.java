package pe.com.BC32.app.parameter.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.BC32.app.parameter.dto.ParameterDto;
import pe.com.BC32.app.parameter.service.IParameterService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/parameters")
public class ParameterController {

    @Autowired
    protected IParameterService service;

    @GetMapping(value = "/getall")
    public Flux<ParameterDto> getall(){
        log.debug("Entering getall parameters " + this.getClass().getName());
        return service.findAll();
    }

    @GetMapping(value = "/get/{id}")
    public Mono<ParameterDto> get(@PathVariable String id){
        log.debug("Entering get parameter " + this.getClass().getName());
        return service.findById(id);
    }

    @GetMapping(value = "/getbypn/{paramNumber}")
    public Flux<ParameterDto> getByParamNumber(@PathVariable String paramNumber) {
        log.debug("Entering getByParamNumber parameter " + this.getClass().getName());
        return service.findByParamNumber(paramNumber);
    }

    @PostMapping(value = "/add")
    public Mono<ParameterDto> add(@RequestBody Mono<ParameterDto> dto){
        log.debug("Entering add parameter " + this.getClass().getName());
        return service.save(dto);
    }

    @PutMapping(value = "/update/{id}")
    public Mono<ParameterDto> update(@RequestBody Mono<ParameterDto> dto, @PathVariable String id){
        log.debug("Entering update parameter " + this.getClass().getName());
        return service.update(dto, id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public Mono<Void> delete(@PathVariable String id) {
        log.debug("Entering delete parameter " + this.getClass().getName());
        return service.delete(id);
    }

}
